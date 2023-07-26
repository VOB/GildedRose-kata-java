package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void updateCommonItem() {
        GildedRose app = new GildedRose(new Item[] {new Common("sword", 10, 10)});
        app.updateItems();
        assertEquals("sword", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void updateItemWhenSellInIsNegative() {
        GildedRose app = new GildedRose(new Item[] {new Common("sword", -1, 10)});
        app.updateItems();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void updateAgedBrie() {
        GildedRose app = new GildedRose(new Item[] {new AgedBrie( 10, 10)});
        app.updateItems();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateBackstagePass() {
        GildedRose app = new GildedRose(new Item[] {new Backstage("Backstage passes to a TAFKAL80ETC concert", 20, 10)});
        app.updateItems();
        assertEquals(19, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void updateBackstagePass10DaysOrLess() {
        GildedRose app = new GildedRose(new Item[] {new Backstage("Backstage passes to a TAFKAL80ETC concert", 10, 10)});
        app.updateItems();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void updateBackstagePass5DaysOrLess() {
        GildedRose app = new GildedRose(new Item[] {new Backstage("Backstage passes to a TAFKAL80ETC concert", 5, 10)});
        app.updateItems();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void updateBackstagePass0DaysLeft() {
        GildedRose app = new GildedRose(new Item[] {new Backstage("Backstage passes to a TAFKAL80ETC concert", 0, 30)});
        app.updateItems();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateConjuredItem() {
        GildedRose app = new GildedRose(new Item[] {new Conjured("Conjured Mana Cake", 3, 6)});
        app.updateItems();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void updateConjuredItemOneQualityLeft() {
        GildedRose app = new GildedRose(new Item[] {new Conjured("Conjured Mana Cake", 3, 1)});
        app.updateItems();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void updateConjuredItemSellInDayPassed() {
        GildedRose app = new GildedRose(new Item[] {new Conjured("Conjured Mushroom", -1, 9)});
        app.updateItems();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
    }

    @Test
    void updateLegendaryItem() {
        GildedRose app = new GildedRose(new Item[] {new Sulfuras()});
        app.updateItems();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void updateItemsDoesntIncreaseQualityAbove50() {
        Item[] items = new Item[] {
            new AgedBrie( 1, 50),
            new Backstage( "Backstage passes to a TAFKAL80ETC concert", 1, 50),
            new Backstage( "Backstage passes to a TAFKAL80ETC concert", 1, 49)
        };
        GildedRose app = new GildedRose(items);
        app.updateItems();
        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(50, app.items[2].quality);
    }

    @Test
    void verifyQualityOfItemsIsNeverNegative() {
        Item[] items = new Item[] {
            new Common("Common greaves", 1, 0),
            new Common("Common greaves", 1, 1),
            new Conjured("Conjured hat", 1, 0),
            new Conjured("Conjured hat", 1, 1),
            new Conjured("Conjured hat", 1, 2),
            new Conjured("Conjured hat", -1, 0),
            new Conjured("Conjured hat", -1, 1),
            new Conjured("Conjured hat", -1, 2),
            new Conjured("Conjured hat", -1, 3),
            new Conjured("Conjured hat", -1, 4)
        };
        GildedRose app = new GildedRose(items);
        app.updateItems();
        for (Item item : app.items) {
            assertEquals(0, item.quality);
        }
    }
}
