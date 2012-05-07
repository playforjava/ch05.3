package controllers;

import static java.lang.String.format;

import java.util.List;

import models.Product;
import models.StockItem;
import models.Warehouse;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

  public static Result index() {
    List<StockItem> items = StockItem.find()
        .where()
        .ge("quantity", 300)
        .orderBy("quantity")
        .setMaxRows(10)
        .findList();

    return ok(items.toString());
  }

}