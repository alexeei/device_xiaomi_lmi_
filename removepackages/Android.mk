LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := RemovePackages
LOCAL_MODULE_CLASS := APPS
LOCAL_MODULE_TAGS := optional
LOCAL_UNINSTALLABLE_MODULE := true
ifneq ($(USE_REMOVE_PACKAGES), full)
LOCAL_OVERRIDES_PACKAGES := Markup \
    MusicFX \
    Music \
    Chrome \
    Maps \
    Drive \
    YouTubeMusicPrebuilt \
    MaestroPrebuilt \
    WellbeingPrebuilt \
    PartnerSetupPrebuilt \
    DreamlinerDreamsPrebuilt \
    DreamlinerPrebuilt \
    DreamlinerUpdater \
    Chrome-Stub \
    SafetyRegulatoryInfo \
    GooglePrintRecommendationService \
    TagGoogle \
    PixelWallpapers2021 \
    EmergencyInfoGoogleNoUi \
    GoogleFeedback \
    QuickAccessWallet \
    WallpaperPickerGoogleRelease \
    Photos \
    PrebuiltGmail \
    CalculatorGooglePrebuilt \
    YouTube \
    Videos \
    RecorderPrebuilt \
    TipsPrebuilt \
    arcore \
    SafetyHubPrebuilt \
	SafetyRegulatoryInfo \
	SoundAmplifierPrebuilt \
	GooglePrintRecommendationService \
	Talkback \
    Gallery \
    GrapheneCamera \
    SoundPickerPrebuilt \
	SwitchAccessPrebuilt \
	BetterBugStub \
	LocationHistoryPrebuilt \
    Panic \
    Sounds \
    AospGallery \
    Seedvault \
	AudioFX \
	Backgrounds \
	Calendar2 \
	Calendar \
	Etar \
	PicoTts \
	Gallery2 \
	Glimpse \
    CarrierMetrics \
	PhotoTable \
    MaestroPrebuilt \
	Recorder \
	GoogleTTS \
	SafetyHubPrebuilt \
    MarkupGoogle \
	Photos \
    TipsPrebuilt \
	TagGoogle \
	talkback \
	PrebuiltBugle \
	CreativeAssistant

endif
LOCAL_CERTIFICATE := PRESIGNED
LOCAL_SRC_FILES := /dev/null
include $(BUILD_PREBUILT)
