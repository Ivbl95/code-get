package com.pb.plugins.codeget;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

import org.json.*;

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
    public void checkUpdates(PluginCall call) throws Exception {
        boolean result = false;
        JSONObject obj = new JSONObject(this.checkUpdateExist());
        String downloadLink = obj.getJSONObject("update_info").getString("download_url");

        if (downloadLink != "") { // Если есть обновления
            this.downloadUpdatesFiles();
            result = true;
        }

        JSObject ret = new JSObject();
        ret.put("result", result);
        ret.put("downloadLink", downloadLink);
        call.resolve(ret);
    }

    public String checkUpdateExist() throws Exception {
        String url = "https://codeget-api.premiumbonus.su/update/update_check?deployment_key=8&app_version=72.0.38&platform=android";
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
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
