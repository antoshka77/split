public enum Filename {
    Letter {
        @Override
        String generateFilename(String baseName, int index) {
            if (index == 0)
                return baseName + "a.txt";
            StringBuilder number = new StringBuilder();
            for (; index > 0; index /= 26) {
                number.append((char) ((index % 26) + 'a'));
            }
            number.reverse().append(".txt");
            return baseName + number;
        }
    },
    Digit {
        @Override
        String generateFilename(String baseName, int index) {
            return baseName + Integer.toString(index + 1) + ".txt";
        }
    };

    abstract String generateFilename(String baseName, int index);
}
