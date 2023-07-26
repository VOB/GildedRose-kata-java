package com.gildedrose;

public class Conjured extends Item {

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void age() {
        sellIn--;
        if (sellIn > 0 && quality > 1) {
            quality = quality - 2;
        } else if (sellIn < 0 && quality > 3) {
            quality = quality - 4;
        } else {
            quality = 0;
        }
    }
}
