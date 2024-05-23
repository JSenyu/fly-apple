package icu.senyu.fly_apple.mixin;

import com.mojang.brigadier.context.CommandContext;
import icu.senyu.fly_apple.effects.EffectRegister;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.commands.GameModeCommand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;

@Mixin(GameModeCommand.class)
public class GameModeCommandMixin {

    @Inject(method = "setMode", at = @At("TAIL"))
    private static void onSetMode(CommandContext<CommandSourceStack> context, Collection<ServerPlayer> serverPlayers, GameType gameType, CallbackInfoReturnable<Integer> cir) {
        serverPlayers.forEach(serverPlayer -> {
            if(gameType == GameType.SURVIVAL && serverPlayer.hasEffect(EffectRegister.FLY_EFFECT.get())){
                serverPlayer.getAbilities().mayfly = true;
                serverPlayer.onUpdateAbilities();
            }
        });
    }
}
