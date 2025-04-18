package com.jinsan09.registry;

import com.google.common.base.Function;
import com.jinsan09.Epic_medieval;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BARLEY_BEEF_STEW = itemRegisterToGroup("barley_beef_stew",
            Item :: new, new Item.Settings());
    public static final Item STEWED_VENISON = itemRegisterToGroup("stewed_venison",
            Item :: new, new Item.Settings());
    public static final Item VENISON_PIES = itemRegisterToGroup("venison_pies",
            Item :: new, new Item.Settings());
    public static final Item LORD_MANDLEY_PIE = itemRegisterToGroup("lord_mandley_pie",
            Item :: new, new Item.Settings());
    public static final Item HONEY_CHICKEN = itemRegisterToGroup("honey_chicken",
            Item :: new, new Item.Settings());
    public static final Item STEAK_AND_KIDNEY_PIE = itemRegisterToGroup("Steak_and_kidney_pie",
            Item :: new, new Item.Settings());
    public static final Item BEEF_PIE = itemRegisterToGroup("beef_pie",
            Item :: new, new Item.Settings());
    public static final Item COD_CAKE = itemRegisterToGroup("cod_cake",
            Item :: new, new Item.Settings());
    public static final Item BROWN_OAT_CAKE = itemRegisterToGroup("brown_oat_cake",
            Item :: new, new Item.Settings());

    public static Item itemRegisterToGroup(String name, Function<Item.Settings, Item> factory, Item.Settings settings, ItemGroup... itemGroup) {

        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Epic_medieval.MOD_ID, name));
        Item registeredItem = Items.register(registryKey, factory, settings);

        for (ItemGroup group : itemGroup) {
            RegistryKey<ItemGroup> groupKey = Registries.ITEM_GROUP.getKey(group).orElseThrow();
            ItemGroupEvents.modifyEntriesEvent(groupKey).register(entries -> entries.add(registeredItem));
        }

        return registeredItem;
    }

    public static void itemToMod(){
        Epic_medieval.LOGGER.debug("Registering Mod Items" + Epic_medieval.MOD_ID);
    }
}
