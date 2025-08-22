package com.hossvel.service;

import com.hossvel.model.Price;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface IProductService {
public Uni<List<Price>> getHistoryPrice();
}
