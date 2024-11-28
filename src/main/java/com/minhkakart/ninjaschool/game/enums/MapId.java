package com.minhkakart.ninjaschool.game.enums;

public enum MapId {
    HIROSAKI_SCHOOL("Trường Hirosaki", "tone"),
    HACHI_FIELD("Đồng Hachi", "tone"),
    SAKURA_PEACH_FOREST("Rừng đào Sakura", "tone"),
    UTRA_BAMBOO_FOREST("Rừng trúc Utra", "tone"),
    MISHIMA_FOREST("Rừng Mishima", "tone"),
    WATAMARO_RIVER("Sông Watamaro", "tone"),
    IZUKO_CEMETERY("Nghĩa địa Izuko", "tone"),
    KOJIN_VILLAGE("Làng Kojin", "tone"),
    KAMO_TEMPLE("Miếu Kamo", "tone"),
    OBOKO_TEMPLE("Miếu Oboko", "tone"),
    OBOKO_TEMPLE_BACKYARD("Sân sau miếu Oboko", "tone"),
    KOUJI_WOOD_FOREST("Rừng gỗ Kouji", "tone"),
    AOKIGAHARA_FOREST("Rừng Aokigahara", "tone"),
    ITO_CLIFF("Vách núi Ito", "tone"),
    TAIRA_VALLEY("Thung lũng Taira", "tone"),
    SANZU_VILLAGE("Làng Sanzu", "tone"),
    OROCHI_TEMPLE_YARD("Sân đền Orochi", "tone"),
    OROCHI_TEMPLE("Ngôi đền Orochi", "tone"),
    OROCHI_TEMPLE_BACKYARD("Sân sau đền Orochi", "tone"),
    TRAINING_PLACE("Khu tập luyện", "tone"),
    KITAJIMA_WATERFALL("Thác Kitajima", "tone"),
    KITAJIMA_WATERFALL_BASE("Chân thác Kitajima", "tone"),
    FUMIMEN_HILL("Đồi Fumimen", "tone"),
    TONE_VILLAGE("Làng Tone", "tone"),
    HARUNA_SCHOOL("Trường Haruna", "tone"),
    HARUNA_STUDENT_HOUSE("Kí túc xá Haruna", "tone"),
    AKA_CAVE_ENTRANCE("Cửa hang Aka", "tone"),
    AKA_CAVE("Hang Aka", "tone"),
    AKAGI_STREAM("Suối Akagi", "tone"),
    OURA_BEACH("Bãi biển Oura", "tone"),
    FISHING_VILLAGE("Làng chài", "tone"),
    KAWAGUCHI_SEAGATE("Cửa biển Kawaguchi", "tone"),
    MOSHIO_FOREST("Rừng Moshio", "tone"),
    HEBI_ISLAND("Đảo Hebi", "tone"),
    MEIRO_CAVE("Hang Meiro", "tone"),
    CHOROCHORO_RAVINE("Khe núi Chorochoro", "tone"),
    ONTAKE_MOUNTAIN("Núi Ontake", "tone"),
    CHAKUMI_VILLAGE("Làng Chakumi", "tone"),
    ANZEN_MOUNTAIN("Núi Anzen", "tone"),
    HONE_PEAK("Mũi Hone", "tone"),
    ICHIDAI_TOP("Đỉnh Ichidai", "tone"),
    KISEI_FIELD("Cánh đồng Kisei", "tone"),
    HASHIGOTO_MOUNTAIN("Núi Hashigoto", "tone"),
    FUKI_FIELD("Cánh đồng Fuki", "tone"),
    KOKORO_HILL("Đồi Kokoro", "tone"),
    ICHIDAI_CLIFF("Vách Ichidai", "tone"),
    AINODAKE_WALL("Vách Ainodake", "tone"),
    DEAD_VALLEY("Thung lũng chết", "tone"),
    OLD_FOREST("Rừng già", "tone"),
    OOKAZA_SCHOOL("Trường Ookaza", "tone"),
    YAMATO_ICED_RIVER("Sông băng Yamato", "tone"),
    STUKI_LAKE("Hồ Stuki", "tone"),
    HA_CAVE("Hang Ha", "tone"),
    TAKANA_CANYON("Hẻm núi Takana", "tone"),
    OSHIN_VILLAGE("Làng Oshin", "tone"),
    KANASHI_FOREST("Rừng Kanashii", "tone"),
    AMATERASU_TEMPLE("Đền Amaterasu", "tone"),
    TOGE_FOREST("Rừng Toge", "tone"),
    KAPPA_FOREST("Rừng Kappa", "tone"),
    KUGYOU_CAVE("Hang Kugyou", "tone"),
    HIYA_FIELD("Cánh đồng Hiya", "tone"),
    NURANURA_PEAK("Mũi Nuranura", "tone"),
    AKAI_RED_STONE_AREA("Khu đá đỏ Akai", "tone"),
    AIKO_RED_STONE_AREA("Khu đá đỏ Aiko", "tone"),
    CHI_CAVE("Hang Chi", "tone"),
    ECHIGO_VILLAGE("Làng Echigo", "tone"),
    OKAMA_PEAK("Đỉnh Okama", "tone"),
    KURAI_MOUNTAIN_CAVE("Hang núi Kurai", "tone"),
    TAMATAMO_CAVE("Động Tamatamo", "tone"),
    HARUMOTO_TEMPLE("Đền Harumoto", "tone"),
    OUNIO_SEAL("Phong ấn Ounio", "tone"),
    ;
    
    private final String mapName;
    private final String dataPath;
    
    MapId(String mapName, String dataPath) {
        this.mapName = mapName;
        this.dataPath = dataPath;
    }
    
    public String getMapName() {
        return mapName;
    }
    
    public String getDataPath() {
        return "/game/mapdata/" + dataPath;
    }
}
