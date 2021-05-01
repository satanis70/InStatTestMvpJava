package ermilov.instattestmvpjava.presenters;

import com.google.gson.JsonObject;

import ermilov.instattestmvpjava.models.matchinfomodels.MatchModel;
import ermilov.instattestmvpjava.services.RetrofitServices;
import ermilov.instattestmvpjava.util.Constants;
import ermilov.instattestmvpjava.views.MathInfoView;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
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
public class MatchInfoPresenter extends MvpPresenter<MathInfoView> {

    public void requestApi(){

        JsonObject jsonParams = new JsonObject();
        jsonParams.addProperty("_p_sport", 1);
        jsonParams.addProperty("_p_match_id", 1724836);

        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("proc", "get_match_info");
        jsonBody.add("params", jsonParams);

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

        retrofitServices.getMatchInfo(jsonBody)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MatchModel.Root>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(MatchModel.@NonNull Root root) {
                        getViewState().onDataCompleteFromApi(root);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getViewState().onDataErrorFromApi(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
