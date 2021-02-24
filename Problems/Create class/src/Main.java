class StringOperations {

    // create static nested class EngString
    static class EngString {
        boolean isEnglishLang;
        String string;

        EngString(boolean isEnglishLang, String string) {
            this.isEnglishLang = isEnglishLang;
            this.string = string;
        }

        public boolean isEnglish() {
            return isEnglishLang;
        }

        public String getString() {
            return string;
        }
    }

}