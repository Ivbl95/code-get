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

    // Метод, активируемый из плагина 'Проверка обновлений'
    @PluginMethod
    public void checkUpdates(PluginCall call) throws Exception {

        // Получить данные из МП для генерации ссылки
        String update_channel = call.getString("update_channel");
        String current_app_version = call.getString("current_app_version");
        String platform = call.getString("platform");

        // Генерация url для получения ссылки на обновления из codeget
        String url = "https://codeget-api.premiumbonus.su/update/update_check?";
        url += "deployment_key=" + update_channel + "&app_version=" + current_app_version + "&platform=" + platform;

        // Получение url на скачивание обновлений
        JSONObject obj = new JSONObject(this.checkUpdateExist(url));
        String downloadLink = obj.getJSONObject("update_info").getString("download_url");

        // Проверка доступности обновлений
        boolean result = false;
        if (downloadLink != "") {

            // Метод установки обновлений
            this.downloadUpdatesFiles(downloadLink);
            result = true;
        }

        // Возврат объекта в МП с информацией об успешности выполненной проверки обновления
        JSObject ret = new JSObject();
        ret.put("result", result);
        ret.put("downloadLink", downloadLink);
        call.resolve(ret);
    }

    // Метод обращения к codeget и получения url на скачивание обновлений
    public String checkUpdateExist(String url) throws Exception {

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

    // Метод загрузки и сохранения архива
    public void downloadUpdatesFiles(String downloadLink) {
        // URL url = new URL(downloadLink);
        // InputStream inputStream = url.openStream();
        // Files.copy(inputStream, new File("/data/data/com.premiumbonus.jamm.agrarium/files/file.zip").toPath());
    }

    // Метод , активируемый из плагина 'Установка обновлений'
    @PluginMethod
    public void installUpdates(PluginCall call) {
        boolean result = false;

        // Распаковка архива
        this.unpackingArchive();

        // Удаление архива
        this.removeUpdatesFiles();

        // Возврат объекта об успешности установки
        JSObject ret = new JSObject();
        ret.put("result", result);
        call.resolve(ret);
    }

    // Метод , активируемый из плагина 'Отказ от обновлений'
    @PluginMethod
    public void rejectUpdates(PluginCall call) {
        boolean result = false;

        // Удаление архива
        this.removeUpdatesFiles();

        // Возврат объекта об успешности отказа
        JSObject ret = new JSObject();
        ret.put("result", result);
        call.resolve(ret);
    }

    // Распаковка архива в нужные папки
    public void unpackingArchive() {

    }

    // Удаление архива
    public void removeUpdatesFiles() {

    }
}
