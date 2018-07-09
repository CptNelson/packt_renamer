import java.io.File;
import java.io.FilenameFilter;

public class RenamerMain
{
    final static String workingDir = System.getProperty("user.dir");

    public static void main(String[] args)
    {

        // create a File from the directory
        File directory = new File(workingDir);

        // Create a File array from directory list and exclude .jar files
        File[] listOfFiles = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                boolean result;
                if (s.endsWith(".jar")){
                    result = false;
                } else {
                    result = true;
                }
                return result;
            }
        });
        if (listOfFiles.length <= 0) {
            System.out.println("The folder is empty! Exiting program.");
            return;
        }


        // Create a String array from directory list and exclude .jar files
        String[] filesInDir = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                boolean result;
                if (s.endsWith(".jar")){
                    result = false;
                } else {
                    result = true;
                }
                return result;
            }
        });

        // remove all non-alphabet chars from beginning of strings,
        // turn all names to lowercase and spaces to underlines.
        String[] afterNumber = RemoveCharsFromBeginning(filesInDir);
        String[] afterLowerCase = AllToLowerCase(afterNumber);
        String[] afterUnderline = SpacesToUnderline(afterLowerCase);

        //rename the files
        RenameFiles(afterUnderline, listOfFiles);

        System.out.println("Done!");

    }

    private static void RenameFiles(String names[], File dir[])
    {
        for (int i = 0; i < names.length;i++) {
            dir[i].renameTo(new File(workingDir + "/" + names[i]));
            System.out.println(names[i]);
        }
    }

    // Remove all non-alphabet characters from start of the strings.
    private static String[] RemoveCharsFromBeginning(String folder[])
    {
        //String[] tempFolder = folder;
        for (int i = 0; i < folder.length; i++) {
            folder[i] = folder[i].replaceFirst("[^a-zA-z]*", "");
        }

        return folder;
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


