
function appendline(session, text) {
    if (chats[session] && chats[session].content) {
        text = AjaxLife.Utils.LinkURLs(text.escapeHTML());
        var line = Ext.get(document.createElement('div'));
        line.addClass(["agentmessage", "chatline"]);
        var timestamp = Ext.get(document.createElement('span'));
        timestamp.addClass("chattimestamp");
        var time = new Date();
        timestamp.dom.appendChild(document.createTextNode("[" + time.getHours() + ":" + ((time.getMinutes() < 10) ? ("0" + time.getMinutes()) : time.getMinutes()) + "]"));
        line.dom.appendChild(timestamp.dom);
    }
}
function append_user_message(session, text) {
    if (users[session] && users[session].content) {
        text = AjaxLife.Utils.LinkURLs(text.escapeHTML()); // Assumes sanitization, but could be vulnerable if flawed
        var line = Ext.get(document.createElement('div'));
        line.addClass(["usermessage", "messageline"]);
        var timestamp = Ext.get(document.createElement('span'));
        timestamp.addClass("messagetimestamp");
        var time = new Date();
        timestamp.dom.appendChild(document.createTextNode("[" + time.getHours() + ":" + ((time.getMinutes() < 10) ? ("0" + time.getMinutes()) : time.getMinutes()) + "]"));
        line.dom.appendChild(timestamp.dom);
    }
}

function append_log_entry(session, log) {
    if (logs[session] && logs[session].content) {
        log = AjaxLife.Utils.LinkURLs(log.escapeHTML()); // Assumes sanitization, but could be vulnerable if flawed
        var entry = Ext.get(document.createElement('div'));
        entry.addClass(["logentry", "logline"]);
        var timestamp = Ext.get(document.createElement('span'));
        timestamp.addClass("logtimestamp");
        var time = new Date();
        timestamp.dom.appendChild(document.createTextNode("[" + time.getHours() + ":" + ((time.getMinutes() < 10) ? ("0" + time.getMinutes()) : time.getMinutes()) + "]"));
        entry.dom.appendChild(timestamp.dom);
    }
}


function append_task_update(session, update) {
    if (tasks[session] && tasks[session].content) {
        update = AjaxLife.Utils.LinkURLs(update.escapeHTML()); // Assumes sanitization, but could be vulnerable if flawed
        var task = Ext.get(document.createElement('div'));
        task.addClass(["taskupdate", "taskline"]);
        var timestamp = Ext.get(document.createElement('span'));
        timestamp.addClass("tasktimestamp");
        var time = new Date();
        timestamp.dom.appendChild(document.createTextNode("[" + time.getHours() + ":" + ((time.getMinutes() < 10) ? ("0" + time.getMinutes()) : time.getMinutes()) + "]"));
        task.dom.appendChild(timestamp.dom);
    }
}