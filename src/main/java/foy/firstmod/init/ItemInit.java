package foy.firstmod.init;

import foy.firstmod.FirstModMain;

import foy.firstmod.items.FuelItem;
import foy.firstmod.items.TeleportStick;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ItemInit {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstModMain.MODID);

    public static final RegistryObject<Item> FOYSWORD = ITEMS.register("foysword",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> FOYCOOKIE = ITEMS.register("foycookie",
            () -> new Item(new Item.Properties().tab(ModCreativeTab.instance)
                    .food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationMod(2)
                            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 200, 0), 0.5F)
                            .alwaysEat()
                            .build())));

    public static final RegistryObject<Item> GAS = ITEMS.register("gas",
            () -> new FuelItem(new Item.Properties().tab(ModCreativeTab.instance), 100));

    public static final RegistryObject<Item> TELEPORT_STICK = ITEMS.register("teleport_stick",
            () -> new TeleportStick(new Item.Properties().tab(ModCreativeTab.instance).durability(50)));

    public static class ModCreativeTab extends CreativeModeTab {

        public ModCreativeTab(String label) {
            super(label);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(FOYSWORD.get());
        }

        public static final ModCreativeTab instance = new ModCreativeTab("firstmod");
    }
}
