package com.gildedrose;

public class Common extends Item{

    public Common(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void age() {
        sellIn--;
        if (quality > 0) {
            quality = quality - 1;
        }
        if (sellIn < 0 && quality > 0) {
            quality = quality - 1;
        }
    }
}
