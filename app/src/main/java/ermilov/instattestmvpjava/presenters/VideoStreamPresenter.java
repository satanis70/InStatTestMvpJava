package ermilov.instattestmvpjava.presenters;

import android.util.Log;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import ermilov.instattestmvpjava.models.videostreammodel.VideoStreamModel;
import ermilov.instattestmvpjava.services.RetrofitServices;
import ermilov.instattestmvpjava.util.Constants;
import ermilov.instattestmvpjava.views.VideoStreamView;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@InjectViewState
public class VideoStreamPresenter extends MvpPresenter<VideoStreamView> {

    public void requestApi(){

        ArrayList<VideoStreamModel> arrayList = new ArrayList<>();

        JsonObject jsonObjectVideo = new JsonObject();
        jsonObjectVideo.addProperty("match_id" , 1724836);
        jsonObjectVideo.addProperty("sport_id", 1);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        RetrofitServices retrofitServices = retrofit.create(RetrofitServices.class);
        retrofitServices.getVideoStreamApi(jsonObjectVideo)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<VideoStreamModel>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<VideoStreamModel> videoStreamModels) {
                        arrayList.addAll(videoStreamModels);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        getViewState().onCompleteVideoStream(arrayList);
                    }
                });
    }
}
