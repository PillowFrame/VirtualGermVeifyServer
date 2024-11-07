package com.omg.pf.client.netty.packet.verify;

import com.omg.pf.netty.packet.GermPacket;
import com.omg.pf.netty.util.GermByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

public abstract class VerifyPluginResultPacket implements WithMessagePacket, GermPacket {
    public String plugin;
    public List<String> messages;
    public String author;
    public String name;

    public VerifyPluginResultPacket() {
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public void onReceive(ChannelHandlerContext var1) throws Exception {
    }

    public void decode(GermByteBuf var1) {
        this.plugin = var1.readString();
        this.name = var1.readString();
        this.author = var1.readString();
        this.messages = var1.readStringList();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void encode(GermByteBuf var1) {
        var1.writeString(this.plugin);
        var1.writeString(this.name);
        var1.writeString(this.author);
        var1.writeStringList(this.messages);
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return (new StringBuilder()).insert(0, "VerifyPluginResultPacket(plugin=").append(this.plugin).append(", name=").append(this.name).append(", author=").append(this.getAuthor()).append(", messages=").append(this.messages).append(")").toString();
    }

    public String getPluginName() {
        return this.plugin;
    }
}
