package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            updateQuality(item);
        }
    }

    public void updateQuality(Item item) {
        if (item instanceof Common) {
            ((Common) item).age();
        }
        if (item instanceof AgedBrie) {
            ((AgedBrie) item).age();
        }
        if (item instanceof Backstage) {
            ((Backstage) item).age();
        }
        if (item instanceof Conjured) {
            ((Conjured) item).age();
        }
    }
}
