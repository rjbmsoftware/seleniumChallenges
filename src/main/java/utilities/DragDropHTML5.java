package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/***
 * Due to selenium not supporting drag and drop in HTML 5 use this
 * https://github.com/seleniumhq/selenium-google-code-issue-archive/issues/3604
 */
public class DragDropHTML5 {
    /**
     * Uses jQuery to implement simple drag and drop
     * @param webDriver cast to javaScriptExecutor
     * @param from css selector
     * @param to css selector
     */
    public static void dragAndDrop(WebDriver webDriver, String from, String to) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeAsyncScript(LOAD_JQUERY_JS);
        String javaScript = DRAG_DROP_JS + "$('" + from + "').simulateDragDrop({ dropTarget: '" + to + "'});";
        javascriptExecutor.executeScript(javaScript);
    }

    private static final String LOAD_JQUERY_JS = "/** dynamically load jQuery */\n" +
            "(function(jqueryUrl, callback) {\n" +
            "    if (typeof jqueryUrl != 'string') {\n" +
            "        jqueryUrl = 'https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js';\n" +
            "    }\n" +
            "    if (typeof jQuery == 'undefined') {\n" +
            "        var script = document.createElement('script');\n" +
            "        var head = document.getElementsByTagName('head')[0];\n" +
            "        var done = false;\n" +
            "        script.onload = script.onreadystatechange = (function() {\n" +
            "            if (!done && (!this.readyState || this.readyState == 'loaded'\n" +
            "                    || this.readyState == 'complete')) {\n" +
            "                done = true;\n" +
            "                script.onload = script.onreadystatechange = null;\n" +
            "                head.removeChild(script);\n" +
            "                callback();\n" +
            "            }\n" +
            "        });\n" +
            "        script.src = jqueryUrl;\n" +
            "        head.appendChild(script);\n" +
            "    }\n" +
            "    else {\n" +
            "        callback();\n" +
            "    }\n" +
            "})(arguments[0], arguments[arguments.length - 1]);";

    private static final String DRAG_DROP_JS = "(function( $ ) {\n" +
            "        $.fn.simulateDragDrop = function(options) {\n" +
            "                return this.each(function() {\n" +
            "                        new $.simulateDragDrop(this, options);\n" +
            "                });\n" +
            "        };\n" +
            "        $.simulateDragDrop = function(elem, options) {\n" +
            "                this.options = options;\n" +
            "                this.simulateEvent(elem, options);\n" +
            "        };\n" +
            "        $.extend($.simulateDragDrop.prototype, {\n" +
            "                simulateEvent: function(elem, options) {\n" +
            "                        /*Simulating drag start*/\n" +
            "                        var type = 'dragstart';\n" +
            "                        var event = this.createEvent(type);\n" +
            "                        this.dispatchEvent(elem, type, event);\n" +
            "\n" +
            "                        /*Simulating drop*/\n" +
            "                        type = 'drop';\n" +
            "                        var dropEvent = this.createEvent(type, {});\n" +
            "                        dropEvent.dataTransfer = event.dataTransfer;\n" +
            "                        this.dispatchEvent($(options.dropTarget)[0], type, dropEvent);\n" +
            "\n" +
            "                        /*Simulating drag end*/\n" +
            "                        type = 'dragend';\n" +
            "                        var dragEndEvent = this.createEvent(type, {});\n" +
            "                        dragEndEvent.dataTransfer = event.dataTransfer;\n" +
            "                        this.dispatchEvent(elem, type, dragEndEvent);\n" +
            "                },\n" +
            "                createEvent: function(type) {\n" +
            "                        var event = document.createEvent(\"CustomEvent\");\n" +
            "                        event.initCustomEvent(type, true, true, null);\n" +
            "                        event.dataTransfer = {\n" +
            "                                data: {\n" +
            "                                },\n" +
            "                                setData: function(type, val){\n" +
            "                                        this.data[type] = val;\n" +
            "                                },\n" +
            "                                getData: function(type){\n" +
            "                                        return this.data[type];\n" +
            "                                }\n" +
            "                        };\n" +
            "                        return event;\n" +
            "                },\n" +
            "                dispatchEvent: function(elem, type, event) {\n" +
            "                        if(elem.dispatchEvent) {\n" +
            "                                elem.dispatchEvent(event);\n" +
            "                        }else if( elem.fireEvent ) {\n" +
            "                                elem.fireEvent(\"on\"+type, event);\n" +
            "                        }\n" +
            "                }\n" +
            "        });\n" +
            "})(jQuery);";
}
