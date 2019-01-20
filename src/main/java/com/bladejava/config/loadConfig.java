package com.bladejava.config;

import com.blade.Blade;
import com.blade.ioc.annotation.Bean;
import com.blade.ioc.annotation.Inject;
import com.blade.loader.BladeLoader;
import io.github.biezhi.anima.Anima;

@Bean
public class loadConfig implements BladeLoader{
    @Inject
    private systemConfig sceneGraphSys;

    @Override
    public void load(Blade blade){
        Anima.open("jdbc:sqlite:system.db");
       sceneGraphSys.upload();
    }
}
