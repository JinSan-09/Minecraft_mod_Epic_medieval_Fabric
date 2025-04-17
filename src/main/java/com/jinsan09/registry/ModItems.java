package com.jinsan09.registry;

import com.jinsan09.Epic_medieval;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item itemAdd(String name, Item item, ItemGroup... itemGroup) {
        Item registeredItem = Registry.register(Registries.ITEM,Identifier.of(Epic_medieval.MOD_ID,name),item);
        for (ItemGroup group : itemGroup) {
            RegistryKey<ItemGroup> groupKey = Registries.ITEM_GROUP.getKey(group).orElseThrow();
            ItemGroupEvents.modifyEntriesEvent(groupKey).register(entries -> entries.add(registeredItem));
        }
        return registeredItem;
    }
}
