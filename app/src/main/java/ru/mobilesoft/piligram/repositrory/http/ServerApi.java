package ru.mobilesoft.piligram.repositrory.http;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import ru.mobilesoft.piligram.model.request.AuthRequest;
import ru.mobilesoft.piligram.model.request.CheckEmailRequest;
import ru.mobilesoft.piligram.model.request.RegistrationRequest;
import ru.mobilesoft.piligram.model.response.People;
import ru.mobilesoft.piligram.model.response.TokenResponse;
import ru.mobilesoft.piligram.model.response.TravelsResponse;

/**
 * Created on 8/7/17.
 * retrofit server API
 */

public interface ServerApi {

    /**
     * регистрация
     *
     * @param request запрос на регистрацияю
     * @return если сервер вернет 201 то все хорошо, иначе ошибка(
     */
    @POST("/api/registration")
    Observable<Boolean> registration(@Body RegistrationRequest request);

    /**
     * проверка e-mail
     *
     * @param request запрос на проверку e-mail
     * @return если сервер вернет 200 то все хорошо, иначе ошибка
     */
    @POST("/api/registration/email")
    Observable<Boolean> checkEmail(@Body CheckEmailRequest request);

    /**
     * авторизация
     *
     * @param request запрос на авторизацию
     * @return токен авторизации
     */
    @POST("/api/auth")
    Observable<TokenResponse> singIn(@Body AuthRequest request);

    /**
     * Отправка файла на сервер
     */
    @POST("/api/images")
    @Multipart
    Observable<Boolean> uploadImage(@Part("data") RequestBody request, @Part MultipartBody.Part file);

    /**
     * отправка аватара пользователя
     */
    @POST("/api/images/avatar")
    @Multipart
    Observable<Boolean> setAvatar(@Part("data") RequestBody request, @Part MultipartBody.Part file);

    /**
     * получить список моих путешествий (тех которые я создал)
     * @return вернет массив моих поездок
     */
    @GET("/api/travels/my")
    Observable<List<TravelsResponse>> getMyTravels();

    /**
     * получить список путешествий
     * @return вернет массив моих поездок
     */
    @GET("/api/travels")
    Observable<List<TravelsResponse>> getTravels();

    /**
     * получить список пользователей, по странично
     * @param page номер страницы
     * @return список пользователей
     */
    @GET("/api/people/all/{page}")
    Observable<List<People>> getPeopleList(@Path("page") int page);


}
