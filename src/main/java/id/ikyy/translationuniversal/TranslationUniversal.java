package id.ikyy.translationuniversal;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = TranslationUniversal.MOD_ID, dist = Dist.CLIENT)
public final class TranslationUniversal {
    public static final String MOD_ID = "translation_universal";

    public TranslationUniversal(IEventBus modBus, ModContainer container) {
        modBus.addListener(this::onClientSetup);
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            Minecraft minecraft = Minecraft.getInstance();
            if (!"id_id".equals(minecraft.options.languageCode)) {
                minecraft.options.languageCode = "id_id";
                minecraft.options.save();
                minecraft.reloadResourcePacks();
            }
        });
    }
}
