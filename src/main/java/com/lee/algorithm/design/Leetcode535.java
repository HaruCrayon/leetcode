package com.lee.algorithm.design;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 535. TinyURL 的加密与解密
 *
 * @author LiJing
 * @version 1.0
 */
public class Leetcode535 {
    /*
        要让【长】【短】网址一一对应

            1. 用【随机数】作为短网址标识
            2. 用【hash码】作为短网址标识
            3. 用【递增数】作为短网址标识

        长网址： https://leetcode.cn/problems/encode-and-decode-tinyurl/description/
        对应的短网址： http://tinyurl.com/4e9iAk
     */

    static class Codec {

        private final Map<String, String> longToShort = new HashMap<>();
        private final Map<String, String> shortToLong = new HashMap<>();
        private final String SHORT_PREFIX = "http://tinyurl.com/";
        private int id = 1;

        private static final char[] toBase62 = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };

        public static String toBase62(int number) {
            if (number == 0) {
                return String.valueOf(toBase62[0]);
            }
            StringBuilder sb = new StringBuilder();
            while (number > 0) {
                int r = number % 62;
                sb.append(toBase62[r]);
                number = number / 62;
            }
            return sb.toString();
        }

        public String encode(String longUrl) {
            String shortUrl = longToShort.get(longUrl);
            if (shortUrl != null) {
                return shortUrl;
            }
            // 生成短网址
//            shortUrl = createShortUrl();
//            shortUrl = createShortUrl(longUrl);
            shortUrl = createShortUrl2();
            longToShort.put(longUrl, shortUrl);
            shortToLong.put(shortUrl, longUrl);
            return shortUrl;
        }

        public String decode(String shortUrl) {
            return shortToLong.get(shortUrl);
        }

        // 用 随机数 作为短网址标识
        private String createShortUrl() {
            String shortUrl = "";
            while (true) {
                int id = ThreadLocalRandom.current().nextInt();
                shortUrl = SHORT_PREFIX + id;
                if (!shortToLong.containsKey(shortUrl)) {
                    return shortUrl;
                }
            }
        }

        // 用 hash码 作为短网址标识
        private String createShortUrl(String longUrl) {
            String shortUrl = "";
            int id = longUrl.hashCode();
            while (true) {
                shortUrl = SHORT_PREFIX + id;
                if (!shortToLong.containsKey(shortUrl)) {
                    return shortUrl;
                }
                id++;
            }
        }

        // 用 递增数 作为短网址标识
        private String createShortUrl2() {
            String shortUrl = SHORT_PREFIX + toBase62(id);
            id++;
            return shortUrl;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.encode("https://leetcode.com/problems/design-tinyurl"));
    }
}
