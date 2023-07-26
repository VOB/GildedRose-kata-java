package com.gildedrose;

public class Backstage extends Item {

    private static final int MAX_QUALITY = 50;

    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void age() {
        sellIn--;
        if (sellIn < 0) {
            quality = 0;
        } else {
            if (quality < MAX_QUALITY) {
                quality = quality + 1;
            }
            if (sellIn < 10 && quality < MAX_QUALITY) {
                quality = quality + 1;
            }
            if (sellIn < 5 && quality < MAX_QUALITY) {
                quality = quality + 1;
            }
        }
    }
}
