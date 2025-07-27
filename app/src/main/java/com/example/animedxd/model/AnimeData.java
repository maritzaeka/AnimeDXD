package com.example.animedxd.model;

import com.example.animedxd.R;

import java.util.ArrayList;
import java.util.List;

public class AnimeData {
    private static List<Anime> animeList = new ArrayList<>();

    public static List<Anime> getAnimeList() {
        return animeList;
    }

    public static void initializeData() {
        animeList.add(new Anime(
                "Death Note",
                "Supernatural, Suspense",
                "Brutal murders, petty thefts, and senseless violence plague the world. Amidst this chaos, Light Yagami, a brilliant high school student, discovers a mysterious notebook known as the 'Death Note'. This supernatural book allows him to kill anyone whose name he writes in it, as long as he knows their face. Driven by a sense of justice and a desire to rid the world of evil, Light assumes the identity of 'Kira' and begins a crusade against criminals. However, his actions draw the attention of the enigmatic detective known only as 'L', sparking a high-stakes game of psychological warfare. As the body count rises and the line between justice and vengeance blurs, Death Note explores the consequences of absolute power, the fragility of morality, and the dark complexities of the human psyche.",
                R.drawable.deathnote
        ));

        animeList.add(new Anime(
                "Naruto: Shippuden",
                "Action, Adventure, Fantasy",
                "Two and a half years after leaving his village for intense training, Naruto Uzumaki returns to Konohagakure stronger and more determined than ever. With his dream of becoming Hokage still burning brightly, Naruto reunites with his comrades to confront the rising threat of the Akatsuki — a dangerous organization of rogue ninja bent on capturing the tailed beasts. As friendships are tested and devastating truths come to light, Naruto faces battles that challenge not only his strength, but his beliefs, emotions, and will to protect those he loves. 'Naruto: Shippuden' delves deeper into the themes of loyalty, identity, and legacy, weaving an epic tale of war, sacrifice, and the unbreakable bonds that define a true shinobi.",
                R.drawable.naruto
        ));

        animeList.add(new Anime(
                "Jujutsu Kaisen",
                "Action, Supernatural",
                "In a world where malevolent curses lurk in the shadows, devouring humans and spreading despair, high schooler Yuji Itadori finds himself thrust into a realm of danger after consuming a powerful cursed object — the finger of the infamous Curse King, Sukuna. Now sharing his body with a deadly entity, Yuji is recruited by the Tokyo Metropolitan Jujutsu Technical High School to learn how to fight curses using jujutsu sorcery. Alongside his fierce classmates and under the guidance of the eccentric Satoru Gojo, Yuji must battle grotesque creatures, uncover sinister conspiracies, and confront his own mortality. 'Jujutsu Kaisen' is a high-octane supernatural saga that blends explosive action, philosophical musings on death, and raw emotional intensity with stunning animation and unforgettable characters.",
                R.drawable.jujutsu_kaisen
        ));

        animeList.add(new Anime(
                "Spy x Family",
                "Action, Comedy",
                "In a world teetering on the edge of political instability, Twilight — a legendary spy known for his flawless missions — is tasked with his most delicate assignment yet: infiltrate an elite private school to get close to a key political figure. But to do so, he must create a fake family. Adopting the identity of Loid Forger, he hastily assembles a 'perfect' family: a wife, Yor, who is secretly a deadly assassin, and a daughter, Anya, who can read minds. Unbeknownst to each other, the Forgers navigate their daily lives while hiding their true identities, leading to hilarious misunderstandings and heartwarming moments. 'Spy x Family' masterfully blends spy intrigue, slice-of-life comedy, and family bonding in a refreshing, feel-good series that explores love, deception, and what it truly means to belong.",
                R.drawable.spy_x_family
        ));

        animeList.add(new Anime(
                "One Piece",
                "Action, Adventure, Fantasy",
                "Barely surviving in a barrel after passing through a terrible whirlpool at sea, carefree Monkey D. Luffy ends up aboard a ship under attack by fearsome pirates. Despite being a naive-looking teenager, Luffy is actually a formidable fighter with a body made of rubber after eating a Devil Fruit. With an unshakable dream to become the Pirate King, he sets off on a grand adventure across dangerous seas, gathering loyal crewmates, battling powerful enemies, and searching for the legendary treasure known as the One Piece.",
                R.drawable.onepiece
        ));


        animeList.add(new Anime(
                "Kimetsu No Yaiba",
                "Action, Supernatural",
                "Ever since the death of his father, the burden of supporting his family has fallen on Tanjirou Kamado's shoulders. Living modestly in the mountains, he works hard and maintains hope for a better future. But his life takes a dark turn when he returns home to find his entire family slaughtered by demons, with only his sister Nezuko surviving—transformed into a demon herself. Determined to save her and avenge his family, Tanjirou joins the Demon Slayer Corps, facing terrifying creatures and uncovering secrets of a brutal, hidden world.",
                R.drawable.kimetsu_no_yaiba
        ));

    }

}