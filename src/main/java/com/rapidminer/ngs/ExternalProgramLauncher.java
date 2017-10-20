package com.rapidminer.ngs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import com.rapidminer.tools.LogService;

/**
 * Created by paskal on 25.07.17.
 */
public class ExternalProgramLauncher {

    public static Map<Object, String> main(String command, String args, Map<Object,String> outputFiles)
    //public static void main()
            throws IOException, InterruptedException {

        //LogService.getRoot().log(Level.INFO, "ExternalProgramLauncher: 'test'.");

        // указываем в конструкторе ProcessBuilder,
        // что нужно запустить программу ls с параметрами -l /dev
        ProcessBuilder procBuilder = new ProcessBuilder(command, args);

        // перенаправляем стандартный поток ошибок на
        // стандартный вывод
        procBuilder.redirectErrorStream(true);

        // запуск программы
        Process process = procBuilder.start();

        // читаем стандартный поток вывода
        // и выводим на экран
        InputStream stdout = process.getInputStream();
        InputStreamReader isrStdout = new InputStreamReader(stdout);
        BufferedReader brStdout = new BufferedReader(isrStdout);

        String line = null;
        Boolean fileCreateFlag = false;
        Map<Object, String> outputFilesMap = new HashMap<>();
        while((line = brStdout.readLine()) != null) {
            if (line.contains("Output File Names:")) {
                fileCreateFlag = true;
            };
            if (fileCreateFlag && line.equals("")) {
                fileCreateFlag = false;
            };
            if (fileCreateFlag) {
                for (Map.Entry<Object, String> pair : outputFiles.entrySet()) {
                    if (line.contains(pair.getValue())) {
                        outputFilesMap.put(pair.getKey(), line);
                    };
                };
            };
            LogService.getRoot().log(Level.INFO, "ExternalProgramLauncher: '" + line + "'.");
        }

        // ждем пока завершится вызванная программа
        // и сохраняем код, с которым она завершилась в
        // в переменную exitVal
        int exitVal = process.waitFor();
        return outputFilesMap;
    }
}
