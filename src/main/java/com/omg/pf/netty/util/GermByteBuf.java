package com.omg.pf.netty.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;
import io.netty.util.ByteProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class GermByteBuf extends ByteBuf {
    private final ByteBuf Field1440;

    public GermByteBuf() {
        this.Field1440 = Unpooled.buffer();
    }

    public GermByteBuf(ByteBuf var1) {
        this.Field1440 = var1;
    }

    public static int Method907(int var0) {
        for (int var1 = 1; var1 < 5; ++var1) {
            if ((var0 & -1 << var1 * 7) == 0) {
                return var1;
            }
        }

        return 5;
    }

    public ByteBuf readBytes(ByteBuffer var1) {
        return this.Field1440.readBytes(var1);
    }

    public ByteBuf setMedium(int var1, int var2) {
        return this.Field1440.setMedium(var1, var2);
    }

    public ByteBuf copy() {
        return this.Field1440.copy();
    }

    public boolean isWritable(int var1) {
        return this.Field1440.isWritable(var1);
    }

    public ByteBuf discardSomeReadBytes() {
        return this.Field1440.discardSomeReadBytes();
    }

    public int readUnsignedShort() {
        return this.Field1440.readUnsignedShort();
    }

    public ByteBuf readBytes(ByteBuf var1) {
        return this.Field1440.readBytes(var1);
    }

    public boolean equals(Object var1) {
        return this.Field1440.equals(var1);
    }

    public int getIntLE(int var1) {
        return this.Field1440.getIntLE(var1);
    }

    public GermByteBuf writeVarInt(int var1) {
        while ((var1 & -128) != 0) {
            this.writeByte(var1 & 127 | 128);
            var1 >>>= 7;
        }

        this.writeByte(var1);
        return this;
    }

    public ByteBuf writeLong(long var1) {
        return this.Field1440.writeLong(var1);
    }

    public long readUnsignedInt() {
        return this.Field1440.readUnsignedInt();
    }

    public Date readDate() {
        return new Date(this.readLong());
    }

    public GermByteBuf writeString(String var1) {
        byte[] var2 = var1.getBytes(StandardCharsets.UTF_8);
        if (var2.length > 32767) {
            throw new EncoderException(String.valueOf((new StringBuilder()).insert(0, "String too big (was ").append(var2.length).append(" bytes encoded, max ").append(32767).append(")")));
        } else {
            this.writeVarInt(var2.length);
            this.writeBytes(var2);
            return this;
        }
    }

    public GermByteBuf writeDate(Date var1) {
        this.writeLong(var1.getTime());
        return this;
    }

    public boolean release(int var1) {
        return this.Field1440.release(var1);
    }

    public ByteBuf getBytes(int var1, ByteBuffer var2) {
        return this.Field1440.getBytes(var1, var2);
    }

    public ByteBuf writeBytes(ByteBuf var1) {
        return this.Field1440.writeBytes(var1);
    }

    public ByteBuf setLong(int var1, long var2) {
        return this.Field1440.setLong(var1, var2);
    }

    public float readFloat() {
        return this.Field1440.readFloat();
    }

    public long readLongLE() {
        return this.Field1440.readLongLE();
    }

    public int compareTo(ByteBuf var1) {
        return this.Field1440.compareTo(var1);
    }

    public ByteBuf getBytes(int var1, byte[] var2, int var3, int var4) {
        return this.Field1440.getBytes(var1, var2, var3, var4);
    }

    public int getUnsignedShort(int var1) {
        return this.Field1440.getUnsignedShort(var1);
    }

    public long readLong() {
        return this.Field1440.readLong();
    }

    public ByteBuf writerIndex(int var1) {
        return this.Field1440.writerIndex(var1);
    }

    public ByteBuf resetWriterIndex() {
        return this.Field1440.resetWriterIndex();
    }

    public int arrayOffset() {
        return this.Field1440.arrayOffset();
    }

    public ByteBuf discardReadBytes() {
        return this.Field1440.discardReadBytes();
    }

    public ByteBuf writeShort(int var1) {
        return this.Field1440.writeShort(var1);
    }

    public ByteBuf copy(int var1, int var2) {
        return this.Field1440.copy(var1, var2);
    }

    public ByteBuffer[] nioBuffers(int var1, int var2) {
        return this.Field1440.nioBuffers(var1, var2);
    }

    public int readMedium() {
        return this.Field1440.readMedium();
    }

    public int readInt() {
        return this.Field1440.readInt();
    }

    public ByteBuf setIndex(int var1, int var2) {
        return this.Field1440.setIndex(var1, var2);
    }

    public long readUnsignedIntLE() {
        return this.Field1440.readUnsignedIntLE();
    }

    public int maxCapacity() {
        return this.Field1440.maxCapacity();
    }

    public int indexOf(int var1, int var2, byte var3) {
        return this.Field1440.indexOf(var1, var2, var3);
    }

    public int writeBytes(ScatteringByteChannel var1, int var2) throws IOException {
        return this.Field1440.writeBytes(var1, var2);
    }

    public ByteBuf retainedSlice() {
        return this.Field1440.retainedSlice();
    }

    public int writeCharSequence(CharSequence var1, Charset var2) {
        return this.Field1440.writeCharSequence(var1, var2);
    }

    public short readShort() {
        return this.Field1440.readShort();
    }

    public int getUnsignedShortLE(int var1) {
        return this.Field1440.getUnsignedShortLE(var1);
    }

    public ByteBuf readBytes(OutputStream var1, int var2) throws IOException {
        return this.Field1440.readBytes(var1, var2);
    }

    public ByteBuf writeBytes(byte[] var1, int var2, int var3) {
        return this.Field1440.writeBytes(var1, var2, var3);
    }

    public ByteBuffer nioBuffer(int var1, int var2) {
        return this.Field1440.nioBuffer(var1, var2);
    }

    public int readUnsignedMediumLE() {
        return this.Field1440.readUnsignedMediumLE();
    }

    public int forEachByteDesc(int var1, int var2, ByteProcessor var3) {
        return this.Field1440.forEachByteDesc(var1, var2, var3);
    }

    public int readBytes(GatheringByteChannel var1, int var2) throws IOException {
        return this.Field1440.readBytes(var1, var2);
    }

    public GermByteBuf Method899(long[] var1) {
        this.writeVarInt(var1.length);
        long[] var2 = var1;
        int var3 = var1.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            this.writeLong(var2[var4]);
        }

        return this;
    }

    public ByteBuf readBytes(ByteBuf var1, int var2) {
        return this.Field1440.readBytes(var1, var2);
    }

    public ByteBuf retainedDuplicate() {
        return this.Field1440.retainedDuplicate();
    }

    public CharSequence readCharSequence(int var1, Charset var2) {
        return this.Field1440.readCharSequence(var1, var2);
    }

    public ByteBuf writeBoolean(boolean var1) {
        return this.Field1440.writeBoolean(var1);
    }

    public boolean release() {
        return this.Field1440.release();
    }

    public ByteBuffer internalNioBuffer(int var1, int var2) {
        return this.Field1440.internalNioBuffer(var1, var2);
    }

    public ByteBuf setZero(int var1, int var2) {
        return this.Field1440.setZero(var1, var2);
    }

    public ByteBuf readBytes(int var1) {
        return this.Field1440.readBytes(var1);
    }

    public ByteBuf duplicate() {
        return this.Field1440.duplicate();
    }

    public int readUnsignedShortLE() {
        return this.Field1440.readUnsignedShortLE();
    }

    public int refCnt() {
        return this.Field1440.refCnt();
    }

    public ByteBuf retain() {
        return this.Field1440.retain();
    }

    public int readableBytes() {
        return this.Field1440.readableBytes();
    }

    public ByteBuf setBoolean(int var1, boolean var2) {
        return this.Field1440.setBoolean(var1, var2);
    }

    public int setBytes(int var1, FileChannel var2, long var3, int var5) throws IOException {
        return this.Field1440.setBytes(var1, var2, var3, var5);
    }

    public int getBytes(int var1, FileChannel var2, long var3, int var5) throws IOException {
        return this.Field1440.getBytes(var1, var2, var3, var5);
    }

    public ByteBuf getBytes(int var1, byte[] var2) {
        return this.Field1440.getBytes(var1, var2);
    }

    public char readChar() {
        return this.Field1440.readChar();
    }

    public ByteBuf writeShortLE(int var1) {
        return this.Field1440.writeShortLE(var1);
    }

    public String toString(int var1, int var2, Charset var3) {
        return this.Field1440.toString(var1, var2, var3);
    }

    public ByteBuf retainedSlice(int var1, int var2) {
        return this.Field1440.retainedSlice(var1, var2);
    }

    public short getUnsignedByte(int var1) {
        return this.Field1440.getUnsignedByte(var1);
    }

    public ByteBuf capacity(int var1) {
        return this.Field1440.capacity(var1);
    }

    public ByteBuf order(ByteOrder var1) {
        return this.Field1440.order(var1);
    }

    public int writerIndex() {
        return this.Field1440.writerIndex();
    }

    public ByteBuf writeMediumLE(int var1) {
        return this.Field1440.writeMediumLE(var1);
    }

    public int setBytes(int var1, InputStream var2, int var3) throws IOException {
        return this.Field1440.setBytes(var1, var2, var3);
    }

    public GermByteBuf writeStringList(List<String> var1) {
        this.writeString(String.join("<@l@>", var1));
        return this;
    }

    public int[] Method901(int var1) {
        int var2 = this.readVarInt();
        if (var2 > var1) {
            throw new DecoderException(String.valueOf((new StringBuilder()).insert(0, "VarIntArray with size ").append(var2).append(" is bigger than allowed ").append(var1)));
        } else {
            int[] var3 = new int[var2];

            for (int var4 = 0; var4 < var3.length; ++var4) {
                var3[var4] = this.readVarInt();
            }

            return var3;
        }
    }

    public int readerIndex() {
        return this.Field1440.readerIndex();
    }

    public double readDouble() {
        return this.Field1440.readDouble();
    }

    public boolean getBoolean(int var1) {
        return this.Field1440.getBoolean(var1);
    }

    public Enum Method902(Class var1) {
        return ((Enum[]) var1.getEnumConstants())[this.readVarInt()];
    }

    public List<String> readStringList() {
        return new LinkedList<>(Arrays.asList(this.readString().split("<@l@>")));
    }

    public ByteBuf writeBytes(ByteBuffer var1) {
        return this.Field1440.writeBytes(var1);
    }

    public int forEachByte(int var1, int var2, ByteProcessor var3) {
        return this.Field1440.forEachByte(var1, var2, var3);
    }

    public int capacity() {
        return this.Field1440.capacity();
    }

    public ByteBuf touch(Object var1) {
        return this.Field1440.touch(var1);
    }

    public ByteOrder order() {
        return this.Field1440.order();
    }

    public String readString() {
        int var1 = this.readVarInt();
        short var2 = 32767;
        if (var1 > var2 * 4) {
            throw new DecoderException(String.valueOf((new StringBuilder()).insert(0, "The received encoded string buffer length is longer than maximum allowed (").append(var1).append(" > ").append(var2 * 4).append(")")));
        } else if (var1 < 0) {
            throw new DecoderException("The received encoded string buffer length is less than zero! Weird string!");
        } else {
            String var3 = this.toString(this.readerIndex(), var1, StandardCharsets.UTF_8);
            this.readerIndex(this.readerIndex() + var1);
            if (var3.length() > var2) {
                throw new DecoderException(String.valueOf((new StringBuilder()).insert(0, "The received string length is longer than maximum allowed (").append(var1).append(" > ").append(var2).append(")")));
            } else {
                return var3;
            }
        }
    }

    public ByteBuf writeBytes(ByteBuf var1, int var2) {
        return this.Field1440.writeBytes(var1, var2);
    }

    public ByteBuf setBytes(int var1, ByteBuf var2, int var3, int var4) {
        return this.Field1440.setBytes(var1, var2, var3, var4);
    }

    public ByteBuf readRetainedSlice(int var1) {
        return this.Field1440.readRetainedSlice(var1);
    }

    public byte[] readAllToByteArray() {
        return this.readByteArray(this.readableBytes());
    }

    public ByteBuf touch() {
        return this.Field1440.touch();
    }

    public ByteBuf setBytes(int var1, byte[] var2, int var3, int var4) {
        return this.Field1440.setBytes(var1, var2, var3, var4);
    }

    public int hashCode() {
        return this.Field1440.hashCode();
    }

    public long getUnsignedIntLE(int var1) {
        return this.Field1440.getUnsignedIntLE(var1);
    }

    public GermByteBuf Method904(UUID var1) {
        this.writeLong(var1.getMostSignificantBits());
        this.writeLong(var1.getLeastSignificantBits());
        return this;
    }

    public ByteBuf writeZero(int var1) {
        return this.Field1440.writeZero(var1);
    }

    public ByteBuf setBytes(int var1, ByteBuffer var2) {
        return this.Field1440.setBytes(var1, var2);
    }

    public int[] Method905() {
        return this.Method901(this.readableBytes());
    }

    public boolean isReadable() {
        return this.Field1440.isReadable();
    }

    public byte getByte(int var1) {
        return this.Field1440.getByte(var1);
    }

    public ByteBuf readBytes(byte[] var1) {
        return this.Field1440.readBytes(var1);
    }

    public int readVarInt() {
        int var1 = 0;
        int var2 = 0;

        byte var3;
        do {
            var3 = this.readByte();
            int var10001 = (var3 & 127) << var2 * 7;
            ++var2;
            var1 |= var10001;
            if (var2 > 5) {
                throw new RuntimeException("VarInt too big");
            }
        } while ((var3 & 128) == 128);

        return var1;
    }

    public int getMediumLE(int var1) {
        return this.Field1440.getMediumLE(var1);
    }

    public boolean readBoolean() {
        return this.Field1440.readBoolean();
    }

    public ByteBuf unwrap() {
        return this.Field1440.unwrap();
    }

    public ByteBuf setShortLE(int var1, int var2) {
        return this.Field1440.setShortLE(var1, var2);
    }

    public short readShortLE() {
        return this.Field1440.readShortLE();
    }

    public ByteBuf setLongLE(int var1, long var2) {
        return this.Field1440.setLongLE(var1, var2);
    }

    public ByteBuf writeFloat(float var1) {
        return this.Field1440.writeFloat(var1);
    }

    public ByteBuf setByte(int var1, int var2) {
        return this.Field1440.setByte(var1, var2);
    }

    public boolean hasMemoryAddress() {
        return this.Field1440.hasMemoryAddress();
    }

    public ByteBuf readSlice(int var1) {
        return this.Field1440.readSlice(var1);
    }

    public UUID Method72() {
        return new UUID(this.readLong(), this.readLong());
    }

    public int getUnsignedMediumLE(int var1) {
        return this.Field1440.getUnsignedMediumLE(var1);
    }

    public long getUnsignedInt(int var1) {
        return this.Field1440.getUnsignedInt(var1);
    }

    public ByteBuf setBytes(int var1, ByteBuf var2, int var3) {
        return this.Field1440.setBytes(var1, var2, var3);
    }

    public ByteBuf markReaderIndex() {
        return this.Field1440.markReaderIndex();
    }

    public ByteBuf ensureWritable(int var1) {
        return this.Field1440.ensureWritable(var1);
    }

    public int getMedium(int var1) {
        return this.Field1440.getMedium(var1);
    }

    public ByteBuf slice(int var1, int var2) {
        return this.Field1440.slice(var1, var2);
    }

    public long Method906() {
        long var1 = 0L;
        int var3 = 0;

        byte var4;
        do {
            var4 = this.readByte();
            long var10001 = (long) (var4 & 127) << var3 * 7;
            ++var3;
            var1 |= var10001;
            if (var3 > 10) {
                throw new RuntimeException("VarLong too big");
            }
        } while ((var4 & 128) == 128);

        return var1;
    }

    public ByteBuf writeChar(int var1) {
        return this.Field1440.writeChar(var1);
    }

    public ByteBuf readBytes(ByteBuf var1, int var2, int var3) {
        return this.Field1440.readBytes(var1, var2, var3);
    }

    public ByteBuf skipBytes(int var1) {
        return this.Field1440.skipBytes(var1);
    }

    public int ensureWritable(int var1, boolean var2) {
        return this.Field1440.ensureWritable(var1, var2);
    }

    public String toString(Charset var1) {
        return this.Field1440.toString(var1);
    }

    public ByteBufAllocator alloc() {
        return this.Field1440.alloc();
    }

    public CharSequence getCharSequence(int var1, int var2, Charset var3) {
        return this.Field1440.getCharSequence(var1, var2, var3);
    }

    public ByteBuf getBytes(int var1, ByteBuf var2, int var3, int var4) {
        return this.Field1440.getBytes(var1, var2, var3, var4);
    }

    public double getDouble(int var1) {
        return this.Field1440.getDouble(var1);
    }

    public byte readByte() {
        return this.Field1440.readByte();
    }

    public ByteBuf getBytes(int var1, ByteBuf var2, int var3) {
        return this.Field1440.getBytes(var1, var2, var3);
    }

    public long getLongLE(int var1) {
        return this.Field1440.getLongLE(var1);
    }

    public ByteBuffer[] nioBuffers() {
        return this.Field1440.nioBuffers();
    }

    public int readBytes(FileChannel var1, long var2, int var4) throws IOException {
        return this.Field1440.readBytes(var1, var2, var4);
    }

    public boolean isReadable(int var1) {
        return this.Field1440.isReadable(var1);
    }

    public ByteBuf readBytes(byte[] var1, int var2, int var3) {
        return this.Field1440.readBytes(var1, var2, var3);
    }

    public short getShort(int var1) {
        return this.Field1440.getShort(var1);
    }

    public int writeBytes(FileChannel var1, long var2, int var4) throws IOException {
        return this.Field1440.writeBytes(var1, var2, var4);
    }

    public ByteBuf writeInt(int var1) {
        return this.Field1440.writeInt(var1);
    }

    public ByteBuf setIntLE(int var1, int var2) {
        return this.Field1440.setIntLE(var1, var2);
    }

    public byte[] readByteArray(int var1) {
        int var2 = this.readVarInt();
        if (var2 > var1) {
            throw new DecoderException(String.valueOf((new StringBuilder()).insert(0, "ByteArray with size ").append(var2).append(" is bigger than allowed ").append(var1)));
        } else {
            byte[] var3 = new byte[var2];
            this.readBytes(var3);
            return var3;
        }
    }

    public GermByteBuf Method909(int[] var1) {
        this.writeVarInt(var1.length);
        int[] var2 = var1;
        int var3 = var1.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            this.writeVarInt(var2[var4]);
        }

        return this;
    }

    public int getUnsignedMedium(int var1) {
        return this.Field1440.getUnsignedMedium(var1);
    }

    public ByteBuf markWriterIndex() {
        return this.Field1440.markWriterIndex();
    }

    public ByteBuf clear() {
        return this.Field1440.clear();
    }

    public ByteBuf setDouble(int var1, double var2) {
        return this.Field1440.setDouble(var1, var2);
    }

    public int setBytes(int var1, ScatteringByteChannel var2, int var3) throws IOException {
        return this.Field1440.setBytes(var1, var2, var3);
    }

    public ByteBuf writeLongLE(long var1) {
        return this.Field1440.writeLongLE(var1);
    }

    public long[] Method910(long[] var1) {
        return this.Method912(var1, this.readableBytes() / 8);
    }

    public ByteBuf getBytes(int var1, OutputStream var2, int var3) throws IOException {
        return this.Field1440.getBytes(var1, var2, var3);
    }

    public int setCharSequence(int var1, CharSequence var2, Charset var3) {
        return this.Field1440.setCharSequence(var1, var2, var3);
    }

    public int readMediumLE() {
        return this.Field1440.readMediumLE();
    }

    public ByteBuf setBytes(int var1, byte[] var2) {
        return this.Field1440.setBytes(var1, var2);
    }

    public int readUnsignedMedium() {
        return this.Field1440.readUnsignedMedium();
    }

    public boolean isReadOnly() {
        return this.Field1440.isReadOnly();
    }

    public ByteBuf setChar(int var1, int var2) {
        return this.Field1440.setChar(var1, var2);
    }

    public GermByteBuf writeVarLong(long var1) {
        for (long var10000 = var1; (var10000 & -128L) != 0L; var10000 = var1) {
            this.writeByte((int) (var1 & 127L) | 128);
            var1 >>>= 7;
        }

        this.writeByte((int) var1);
        return this;
    }

    public boolean hasArray() {
        return this.Field1440.hasArray();
    }

    public long memoryAddress() {
        return this.Field1440.memoryAddress();
    }

    public int bytesBefore(byte var1) {
        return this.Field1440.bytesBefore(var1);
    }

    public int forEachByte(ByteProcessor var1) {
        return this.Field1440.forEachByte(var1);
    }

    public int bytesBefore(int var1, int var2, byte var3) {
        return this.Field1440.bytesBefore(var1, var2, var3);
    }

    public ByteBuf setMediumLE(int var1, int var2) {
        return this.Field1440.setMediumLE(var1, var2);
    }

    public char getChar(int var1) {
        return this.Field1440.getChar(var1);
    }

    public int maxWritableBytes() {
        return this.Field1440.maxWritableBytes();
    }

    public ByteBuf slice() {
        return this.Field1440.slice();
    }

    public int nioBufferCount() {
        return this.Field1440.nioBufferCount();
    }

    public ByteBuf writeByte(int var1) {
        return this.Field1440.writeByte(var1);
    }

    public int getBytes(int var1, GatheringByteChannel var2, int var3) throws IOException {
        return this.Field1440.getBytes(var1, var2, var3);
    }

    public ByteBuf writeIntLE(int var1) {
        return this.Field1440.writeIntLE(var1);
    }

    public int writableBytes() {
        return this.Field1440.writableBytes();
    }

    public ByteBuffer nioBuffer() {
        return this.Field1440.nioBuffer();
    }

    public ByteBuf retain(int var1) {
        return this.Field1440.retain(var1);
    }

    public ByteBuf setInt(int var1, int var2) {
        return this.Field1440.setInt(var1, var2);
    }

    public boolean isWritable() {
        return this.Field1440.isWritable();
    }

    public String toString() {
        return this.Field1440.toString();
    }

    public int getInt(int var1) {
        return this.Field1440.getInt(var1);
    }

    public ByteBuf resetReaderIndex() {
        return this.Field1440.resetReaderIndex();
    }

    public byte[] array() {
        return this.Field1440.array();
    }

    public long[] Method912(long[] var1, int var2) {
        int var3 = this.readVarInt();
        if (var1 == null || var1.length != var3) {
            if (var3 > var2) {
                throw new DecoderException(String.valueOf((new StringBuilder()).insert(0, "LongArray with size ").append(var3).append(" is bigger than allowed ").append(var2)));
            }

            var1 = new long[var3];
        }

        for (int var4 = 0; var4 < var1.length; ++var4) {
            var1[var4] = this.readLong();
        }

        return var1;
    }

    public int forEachByteDesc(ByteProcessor var1) {
        return this.Field1440.forEachByteDesc(var1);
    }

    public ByteBuf writeBytes(byte[] var1) {
        return this.Field1440.writeBytes(var1);
    }

    public GermByteBuf writeBytesGerm(byte[] var1) {
        this.writeVarInt(var1.length);
        this.writeBytes(var1);
        return this;
    }

    public byte[] readBytesGerm(GermByteBuf buf) {
        int length = this.readVarInt();
        byte[] read = new byte[length];
        this.readBytes(read);
        return read;
    }

    public int bytesBefore(int var1, byte var2) {
        return this.Field1440.bytesBefore(var1, var2);
    }

    public int writeBytes(InputStream var1, int var2) throws IOException {
        return this.Field1440.writeBytes(var1, var2);
    }

    public ByteBuf writeMedium(int var1) {
        return this.Field1440.writeMedium(var1);
    }

    public ByteBuf setBytes(int var1, ByteBuf var2) {
        return this.Field1440.setBytes(var1, var2);
    }

    public ByteBuf setFloat(int var1, float var2) {
        return this.Field1440.setFloat(var1, var2);
    }

    public float getFloat(int var1) {
        return this.Field1440.getFloat(var1);
    }

    public short readUnsignedByte() {
        return this.Field1440.readUnsignedByte();
    }

    public ByteBuf readerIndex(int var1) {
        return this.Field1440.readerIndex(var1);
    }

    public ByteBuf writeBytes(ByteBuf var1, int var2, int var3) {
        return this.Field1440.writeBytes(var1, var2, var3);
    }

    public ByteBuf getBytes(int var1, ByteBuf var2) {
        return this.Field1440.getBytes(var1, var2);
    }

    public ByteBuf writeDouble(double var1) {
        return this.Field1440.writeDouble(var1);
    }

    public ByteBuf asReadOnly() {
        return this.Field1440.asReadOnly();
    }

    public boolean isDirect() {
        return this.Field1440.isDirect();
    }

    public long getLong(int var1) {
        return this.Field1440.getLong(var1);
    }

    public ByteBuf setShort(int var1, int var2) {
        return this.Field1440.setShort(var1, var2);
    }

    public short getShortLE(int var1) {
        return this.Field1440.getShortLE(var1);
    }

    public int readIntLE() {
        return this.Field1440.readIntLE();
    }
}
