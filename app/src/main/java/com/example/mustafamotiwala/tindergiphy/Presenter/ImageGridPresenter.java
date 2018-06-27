package com.example.mustafamotiwala.tindergiphy.Presenter;

import com.example.mustafamotiwala.tindergiphy.Base.BasePresenter;
import com.example.mustafamotiwala.tindergiphy.Model.TinderGifFeed;
import com.example.mustafamotiwala.tindergiphy.Network.ApiClient;
import com.example.mustafamotiwala.tindergiphy.Network.ApiService;
import com.example.mustafamotiwala.tindergiphy.UI.GiphyFeedView;
import com.example.mustafamotiwala.tindergiphy.Utils.StringUtils;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ImageGridPresenter<V extends GiphyFeedView> extends BasePresenter<V> implements ImageGridContract<V> {

    private Single<TinderGifFeed> _tinderGifFeedSingle;
    private Single<TinderGifFeed> _tinderSecondPageFeedSingle;
    private ApiService _apiService;

    CompositeDisposable _disposable;

    public ImageGridPresenter() {
        _apiService = ApiClient.getClient(StringUtils.BASE_API_URL).create(ApiService.class);
        _tinderGifFeedSingle = _apiService.getFirstPageTrendingGifs(StringUtils.API_KEY);
        _disposable = new CompositeDisposable();
    }

    @Override
    public void showContent() {
        _tinderGifFeedSingle
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<TinderGifFeed>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        _disposable.add(d);
                    }

                    @Override
                    public void onSuccess(TinderGifFeed gifFeed) {
                        // Data is ready, update the UI
                        if(isBound()) {
                            getView().showContent(gifFeed.getData());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        //Show error here
                        System.out.println("Error here at : " + e.getLocalizedMessage());
                    }
                });
    }

    @Override
    public void loadMore(int offset) {
        _tinderSecondPageFeedSingle = _apiService.getNextPageTrendingGifs(StringUtils.API_KEY, offset);
        _tinderSecondPageFeedSingle
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<TinderGifFeed>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        _disposable.add(d);
                    }

                    @Override
                    public void onSuccess(TinderGifFeed gifFeed) {
                        // Data is ready, update the UI
                        getView().appendContent(gifFeed.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        //Show error here
                        System.out.println("Error here at : " + e.getLocalizedMessage());
                    }
                });
    }


    @Override
    public void detach() {
        if(!_disposable.isDisposed()) {
            _disposable.dispose();
        }
        super.detach();
    }
}