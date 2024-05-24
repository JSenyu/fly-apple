package icu.senyu.fly_apple.client;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.block.BlockRegister;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = FlyAppleMod.MOD_ID, value = Dist.CLIENT)
public class ClientBlockRender {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // 设置方块的渲染层为半透明
        ItemBlockRenderTypes.setRenderLayer(BlockRegister.SKY_WHEAT.get(), RenderType.cutout());
    }
}
