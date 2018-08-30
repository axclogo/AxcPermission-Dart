
$(function() {
    if (isIE()) {
        alert('不支持IE系列浏览器,请换其他浏览器使用,谢谢!');
        return;
    }
    // $('.input_json_filed').setTextareaCount();
    let s_title  = $(".select_box span");
    let s_select = $(".select_box li");
    let title    = $(document).attr('title');
    let language = WHCParserLanguage.Unknown;
    setLanguageType(title);
    resetLayout();

    function setLanguageType(type) {
        if (type != null && type.length > 0) {
            if (type == 'json转Swift模型' || type == 'Swift') {
                s_title.html('Swift');
                language = WHCParserLanguage.Swift;
            }else if (type == 'json转C#模型' || type == 'C#') {
                s_title.html('C#');
                language = WHCParserLanguage.CNet;
            }else if (type == 'json转Java模型' || type == 'Java') {
                s_title.html('Java');
                language = WHCParserLanguage.Java;
            }else if (type == 'json转Objective-c模型' || type == 'Objective-c') {
                s_title.html('Objective-c');
                language = WHCParserLanguage.OC;
            }else if (type == 'SexyJson(Class)') {
                s_title.html('SexyJson(Class)');
                language = WHCParserLanguage.SwiftSexyJsonClass;
            }else if (type == 'SexyJson(Struct)') {
                s_title.html('SexyJson(Struct)');
                language = WHCParserLanguage.SwiftSexyJson;
            }
        }
    }

    function resetLayout() {
        let body_height = $('body').height();
        let body_width = $('body').width();
        let height_decs = 58;
        $('.json_div').css('height', body_height - height_decs).css('width', body_width - 20);
        $('.input_json_filed').css('height', body_height - height_decs);
        updateInputJsonFiledSize();
    }

    s_title.click(function(e) {
        $(this).addClass("span_aa");
        $(this).next("ul").show();
        e.stopPropagation();
    });  
    
    s_select.click(function() {
        let s_text = $(this).html();
        let s_title_2 = $(this).parent('ul').prev("span");
        s_title_2.html(s_text).removeClass("span_aa");
        $(this).parent('ul').hide();  
        setLanguageType(s_text);
        let json_str = $('.input_json_filed').val();
        if (json_str.length > 0) {
            $('.make_model_btn').trigger("click");
        }
    });
    
    $(document).click(function() {
        s_title.removeClass("span_aa");
        $(".select_box ul").hide();  
    }); 

    $(window).resize(function() {
        resetLayout();
    });

    $('.make_pay_btn').click(function (e){
        e.preventDefault();
        location.href = '/pay/';
    });

    $('.make_model_btn').click(function (e) { 
        e.preventDefault();
        let json_str = $('.input_json_filed').val();
        let root_class_name = $('.input_root_class').val();
        if (json_str.length > 0) {
            if (language == WHCParserLanguage.Unknown) {
                alert('未知语言类型');
                return;
            }
            let json_parser = new WHCJsonParser(language);
            let format_json = JSON.stringify(JSON.parse(json_str),null,4);
            if (root_class_name != null && root_class_name.length > 0) {
                json_parser.rootClassName = root_class_name;
            }
            $('.input_json_filed').val(format_json);
            let results = json_parser.startParser(json_str);
            if (results.length > 1) {
                commitRecord(language)
                let header_content = results[0];
                let implementation_content = results[1];
                switch (json_parser.type) {
                    case WHCParserLanguage.OC:
                        $('.input_json_div').css('width', '50%');
                        $('.class_div').show().css('width','50%');
                        $('.json_div').css('display', '-webkit-flex');
                        $('.model_class_div').show().css('height','70%');
                        $('.model_header_div').show().css('height','30%');
                        $('.model_class_filed').val(header_content);       
                        $('.model_header_filed').val(implementation_content);
                        break;
                    default:
                        $('.model_header_div').hide();
                        $('.model_class_filed').val(implementation_content);       
                        $('.json_div').css('display', '-webkit-flex');
                        $('.class_div').show().css('width','50%');
                        $('.model_class_div').show().css('height', '100%');
                        $('.input_json_div').css('width', '50%');
                        break;
                }
                updateInputJsonFiledSize();
            }
        }else {
            alert('请输入或者粘贴json字符串');
        }
    });

    function commitRecord(language_type) {
        let language = WHCParserLanguage.desc(language_type)
        $.ajax({
            type: "post",
            url: "/jsonModel/",
            data: {language: language},
            dataType: "json",
            success: function (response) {
                
            }
        });
    }

    function updateInputJsonFiledSize() {
        let body_width = $('body').width();
        $('.json_div').width(body_width - 22);
        let json_div_width = $('.json_div').width();
        if ($('.model_class_div').css('display') != 'none') {
            $('.input_json_filed').css('width', json_div_width / 2.0 - 4);
        }else {
            $('.input_json_filed').css('width', json_div_width);
        }
    }

    $('.input_json_filed').bind('input propertychange', function (e) {
        e.preventDefault();
        let json_str = $('.input_json_filed').val();
        if (json_str != null && json_str.length > 0) { 
            $('.input_json_filed_note').hide();
            let format_json = JSON.stringify(JSON.parse(json_str),null,6);
            if (format_json != null && format_json.length > 0) {
                $('.input_json_filed').val(format_json);       
            }
        }else {
            $('.input_json_filed_note').show();
        }
    });

    function isIE() {
        return !!window.ActiveXObject || "ActiveXObject" in window;
    } 
});