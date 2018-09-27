package my.mock;


public class FSMocks {

   public static AFSMock fsAMock = new AFSMock() {
        @Override
        protected String[] getData() {
            return new String[] {
                "/mnt/sdcard/folder1/a/b/file1.file",
                "/mnt/sdcard/folder1/a/b/file2.file",
                "/mnt/sdcard/folder1/a/b/file3.file",
                "/mnt/sdcard/folder1/a/b/file4.file",
                "/mnt/sdcard/folder1/a/b/file5.file",
                "/mnt/sdcard/folder1/e/c/file6.file",
                "/mnt/sdcard/folder2/d/file7.file",
                "/mnt/sdcard/folder2/d/file8.file",
                "/mnt/sdcard/file9.file"
            };
        }
    };

    public static AFSMock fsBMock = new AFSMock() {
        @Override
        protected String[] getData() {
            return new String[] {
                "/home/me/docs/a/b/file1.file",
                "/home/me/notes/a/b/file2.file",
                "/home/me/notes/a/b/file3.file",
                "/home/me/notes/a/b/file4.file",
                "/home/me/notes/a/b/file5.file",
                "/home/me/notes/e/c/file6.file",
                "/home/me/images/d/file7.file",
                "/home/me/images/d/file8.file",
                "/home/me/file9.file"
            };
        }
    };
}
