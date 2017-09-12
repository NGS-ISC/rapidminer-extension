package com.rapidminer.ngs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import com.rapidminer.tools.LogService;

/**
 * Created by paskal on 25.07.17.
 */
public class ExternalProgramLauncher {

    public static void main(String command, String args)
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
        while((line = brStdout.readLine()) != null) {
            LogService.getRoot().log(Level.INFO, "ExternalProgramLauncher: '" + line + "'.");
        }

        // ждем пока завершится вызванная программа
        // и сохраняем код, с которым она завершилась в
        // в переменную exitVal
        int exitVal = process.waitFor();
    }
}
