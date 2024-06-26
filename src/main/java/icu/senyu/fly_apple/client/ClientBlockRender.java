package icu.senyu.fly_apple.client;

import icu.senyu.fly_apple.FlyAppleMod;
import icu.senyu.fly_apple.block.BlockRegister;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = FlyAppleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientBlockRender {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // ���÷������Ⱦ��Ϊ��͸��
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(BlockRegister.SKY_WHEAT.get(), RenderType.translucent());
        });
    }
}
