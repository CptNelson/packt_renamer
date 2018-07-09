import java.io.File;

public class Main
{
    public static void main(String[] args)
    {
        // create a File from the directory
        File directory = new File("/path/to/directory");

        // Create a File array from directory list
        File[] listOfFiles = directory.listFiles();

        // Create a String array from directory list
        String[] filesInDir = directory.list();

        // remove all non-alphabet chars from beginning of strings,
        // turn all names to lowercase and spaces to underlines.
        String[] afterNumber = RemoveCharsFromBeginning(filesInDir);
        String[] afterLowerCase = AllToLowerCase(afterNumber);
        String[] afterUnderline = SpacesToUnderline(afterLowerCase);

        //rename the files
        RenameFiles(afterUnderline, listOfFiles);

    }

    private static void RenameFiles(String names[], File dir[])
    {
        for (int i = 0; i < names.length;i++) {
            dir[i].renameTo(new File("/path/to/directory/"+names[i]));
        }
    }

    // Remove all non-alphabet characters from start of the strings.
    private static String[] RemoveCharsFromBeginning(String folder[])
    {
        String[] tempFolder = folder;
        for (int i = 0; i < folder.length; i++) {
            tempFolder[i] = folder[i].replaceFirst("[^a-zA-z]*", "");
        }

        return tempFolder;
    }

    private static String[] AllToLowerCase(String folder[])
    {
        String[] tempFolder = folder;
        for (int i = 0; i < folder.length; i++) {
            tempFolder[i] = folder[i].toLowerCase();
        }

        return tempFolder;
    }

        private static String[] SpacesToUnderline(String folder[])
    {
        String[] tempFolder = folder;
        for (int i = 0; i < folder.length; i++) {
            tempFolder[i] = folder[i].replaceAll("\\s", "_");
        }

        return tempFolder;
    }

}


