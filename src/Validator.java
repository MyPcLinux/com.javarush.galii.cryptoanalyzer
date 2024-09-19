public class Validator {
    public static boolean isValidKey(String key, char[] alphabet) {
        try {
            int keyInt = Integer.parseInt(key);  // Преобразуем строку один раз
            // Проверяем все условия в одном if-блоке
            if (keyInt == alphabet.length || keyInt == 0 || key.isEmpty() || keyInt > 40 || keyInt < -40) {
                return false;
            }
        } catch (NumberFormatException exception) {
            return false;  // Если ключ не число, возвращаем false
        }
        return true;
    }
    public static boolean isFileExists() {
        if (FileManager.getFile() == null) {
            return false;
        }
        return true;
    }
}