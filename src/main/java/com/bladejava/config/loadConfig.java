package com.bladejava.config;


/**
 * @loadConfig 这个类用于web应用的初始化，例如从数据库中加载数据等
 * @author 张奥东
 * */
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
        /* 配置数据库操作库 */
        Anima.open("jdbc:sqlite:system.db");

        /* 加载景点数据到内存中 */
        sceneGraphSys.upload();
    }
}
