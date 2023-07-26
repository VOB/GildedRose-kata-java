package com.gildedrose;

public class AgedBrie extends Item {

    private static final String NAME = "Aged Brie";
    private static final int MAX_QUALITY = 50;
    public AgedBrie(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    public void age() {
        sellIn--;
        if (quality < MAX_QUALITY ) {
            quality++;
        }
    }
}
