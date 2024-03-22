package com.example.bimbodemo.presentation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bimbodemo.data.database.dbmodel.Beer;
import com.example.bimbodemo.domain.model.BeerDomain;
import com.example.bimbodemo.domain.model.Results;
import com.example.bimbodemo.domain.usecase.beer.DeleteBeersUseCase;
import com.example.bimbodemo.domain.usecase.beer.FetchBeersUseCase;
import com.example.bimbodemo.domain.usecase.beer.GetBeersUseCase;
import com.example.bimbodemo.domain.usecase.beer.GetDescriptionBeerUseCase;
import com.example.bimbodemo.domain.usecase.beer.SaveBeersUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class ListViewModel extends ViewModel {
    CompositeDisposable disposables = new CompositeDisposable();
    private GetBeersUseCase getBeersUseCase;
    private FetchBeersUseCase fetchBeersUseCase;
    private DeleteBeersUseCase deleteBeersUseCase;
    private SaveBeersUseCase saveBeersUseCase;
    private GetDescriptionBeerUseCase getDescriptionBeerUseCase;
    public MutableLiveData<List<BeerDomain>> resultsLiveData = new MutableLiveData<>();
    public MutableLiveData<String> errorLiveData = new MutableLiveData<>();

    public MutableLiveData<List<BeerDomain>> beerLiveData = new MutableLiveData<>();

    public MutableLiveData<BeerDomain> getBeerLiveData = new MutableLiveData<>();

    @Inject
    public ListViewModel(GetBeersUseCase getBeersUseCase,
                         FetchBeersUseCase fetchBeersUseCase,
                         DeleteBeersUseCase deleteBeersUseCase,
                         SaveBeersUseCase saveBeersUseCase,
                         GetDescriptionBeerUseCase getDescriptionBeerUseCase
                         ) {
        this.getBeersUseCase = getBeersUseCase;
        this.fetchBeersUseCase = fetchBeersUseCase;
        this.deleteBeersUseCase = deleteBeersUseCase;
        this.saveBeersUseCase = saveBeersUseCase;
        this.getDescriptionBeerUseCase = getDescriptionBeerUseCase;
    }

    public void getBeers() {
        disposables.add(getBeersUseCase.getBeers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> {
                            deleteBeers();
                            ArrayList<BeerDomain> beerDomainArrayList = new ArrayList<>();
                            for (Results res:result) {
                                beerDomainArrayList.add(new BeerDomain(res));
                                saveBeer(res);
                            }
                            resultsLiveData.postValue(beerDomainArrayList);
                        },
                        error -> errorLiveData.postValue("Error occurred: ")
                ));
    }

    public void saveBeer(Results res){
        Beer beer = new Beer();
        beer.name = res.getName();
        beer.imageUrl = res.getImageUrl();
        beer.description = res.getDescription();
        beer.tagline = res.getTagline();

        saveBeers(new Beer());
    }

    public void saveBeers(Beer beer) {
        saveBeersUseCase.saveBeer(beer);
    }

    public void deleteBeers() {
        deleteBeersUseCase.deleteBeer();
    }

    public void fetchBeers() {
        disposables.add(fetchBeersUseCase.fetchBeers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> {
                            ArrayList<BeerDomain> beerDomainArrayList = new ArrayList<>();
                            for (Beer res:result) {
                                beerDomainArrayList.add(new BeerDomain(res));
                            }
                            beerLiveData.postValue(beerDomainArrayList);
                        },
                        error -> errorLiveData.postValue("Error occurred: ")
                ));
    }

    public void getBeer(Long beerId) {
        disposables.add(getDescriptionBeerUseCase.getBeer(beerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> {
                            getBeerLiveData.postValue(new BeerDomain(result));
                        },
                        error -> errorLiveData.postValue("Error occurred: ")
                ));
    }


}
