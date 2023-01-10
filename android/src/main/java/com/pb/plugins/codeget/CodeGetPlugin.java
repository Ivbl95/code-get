package com.pb.plugins.codeget;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "CodeGet")
public class CodeGetPlugin extends Plugin {

    private CodeGet implementation = new CodeGet();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void checkUpdates(PluginCall call) {
        boolean result = false;
        String downloadLink = this.checkUpdateExist(); // Проверка обновления
        if (downloadLink != "") { // Если есть обновления
        this.downloadUpdatesFiles();
        result = true;
        }
        JSObject ret = new JSObject();
        ret.put("result", result);
        call.resolve(ret);
    }

    public String checkUpdateExist() { // асинхронность?

    }

    public void downloadUpdatesFiles() { // асинхронность?
    // Установка обновления
    // Имплементация способа хранить файлы для установки
    }

    @PluginMethod
    public void installUpdates(PluginCall call) {
        boolean result = false;

        this.unpackingArchive();
        this.removeUpdatesFiles();

        JSObject ret = new JSObject();
        ret.put("result", result);
        call.resolve(ret);
    }

    @PluginMethod
    public void rejectUpdates(PluginCall call) {
        boolean result = false;

        this.removeUpdatesFiles();

        JSObject ret = new JSObject();
        ret.put("result", result);
        call.resolve(ret);
    }

    public void unpackingArchive() {
    // Распаковка
    }

    public void removeUpdatesFiles() {
    // Удаление архива
    }
}
