package project.mmxcix.common.messages;

import project.mmxcix.common.files.LanguageFile;

public class MessageNode {


    //Prefix
    public static String prefix;

    //Basic system response
    public static String permissionDenied;
    public static String consoleCannotSend;

    //Basic player response
    public static String playerNotFound;

    static {
        //Prefix
        MessageNode.prefix = LanguageFile.getLangFile().getString("Prefix");

        //Basic system response
        MessageNode.permissionDenied = LanguageFile.getLangFile().getString("System-Response.permission-denied");
        MessageNode.consoleCannotSend = LanguageFile.getLangFile().getString("System-Response.console-cannot-send");

        //Basic player response
        MessageNode.playerNotFound = LanguageFile.getLangFile().getString("Player-Response.not-found");
    }
}