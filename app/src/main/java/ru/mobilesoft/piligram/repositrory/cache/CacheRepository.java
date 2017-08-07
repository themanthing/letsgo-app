package ru.mobilesoft.piligram.repositrory.cache;

/**
 * Репозиторий для хранения данных в RAM (не должны сохраняться при перезапуске приложения)
 */
public class CacheRepository {
    private static volatile CacheRepository instance;
    private String authLogin;

    public static CacheRepository getInstance() {
        if (instance == null) {
            instance = new CacheRepository();
        }
        return instance;
    }

    public String getAuthLogin() {
        return authLogin;
    }

    /**
     * Временное хранение логина пользователя при процессе авторизации.
     * Формат: 10 цифр без пробелов и прочих символов
     *
     * @param login
     */
    public void setAuthLogin(String login) {
        authLogin = login;
    }
}
