package ru.mobilesoft.piligram.repositrory.cache;

import java.util.ArrayList;
import java.util.List;

import ru.mobilesoft.piligram.model.Travel;
import ru.mobilesoft.piligram.model.response.People;

/**
 * Репозиторий для хранения данных в RAM (не должны сохраняться при перезапуске приложения)
 */
public class CacheRepository {
    private static volatile CacheRepository instance;

    private People me;

    private List<Travel> travels;
    private List<Travel> myTravels;
    private List<People> peoples;

    public static CacheRepository getInstance() {
        if (instance == null) {
            instance = new CacheRepository();
        }
        return instance;
    }

    public People getMe() {
        return me;
    }

    public void setMe(People me) {
        this.me = me;
    }

    public void addTravels(List<Travel> travels) {
        if (this.travels == null){
            this.travels = new ArrayList<>();
        }
        this.travels.addAll(travels);
    }

    public List<Travel> getTravels(){
        return travels;
    }

    public void addMyTravels(List<Travel> travels) {
        if (this.myTravels == null){
            this.myTravels = new ArrayList<>();
        }
        this.myTravels.addAll(travels);
    }

    public List<Travel> getMyTravels(){
        return myTravels;
    }

    public void addPeoples(List<People> peoples) {
        if (this.peoples == null){
            this.peoples = new ArrayList<>();
        }
        this.peoples.addAll(peoples);
    }

    public List<People> getPeoples(){
        return peoples;
    }

}
