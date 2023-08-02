<p align="center">
    <img src="https://github.com/sandbattle/oneuuid/assets/69411255/5f75242b-6202-4eec-8437-b7fae04fb34e">
</p>

> #  OneUUID
> **Stop using `.equalsIgnoreCase()` or search functions on top of a `HashMap` to get your Profiles and Player Data!** We handle it for you with OneUUID. It takes less than 5 minutes to integrate, and the benefits are boundless. Let's go!
>
> - [**Introduction**](#introduction) • [Extra Resources](#extra-resources) • [Attributions](#attributions) • [Contributing](#contributing)
> - [**Getting Started**](#getting-started) • [Downloading](#downloading) • [Use OneUUID](#use-oneuuid) • [Complex Usage](#complex-usage)
> - [**The SB4D Program**](#the-sb4d-program) • [Configure Extensions](#configure-extensions) • [This Library](#this-library)
>

## Introduction
OneUUID is a cutting-edge open-source plugin extension/library that revolutionizes UUID (Universally Unique Identifier) management for software applications and plugins. With an unwavering focus on efficiency and precision, OneUUID offers developers a seamless solution to prevent instance reference confusion, ensuring every instance receives a unique and unequivocal identifier in the Java memory.

By automatically handling UUIDs, OneUUID mitigates conflicts and data corruption, optimizing data integrity and facilitating consistent performance.Moreover, OneUUID boasts an ingenious integration feature, enabling developers to effortlessly link their projects with popular platforms like Discord through its Forums' Linking system. This dynamic integration opens up new possibilities for data synchronization and enhanced communication, fostering a more immersive and interactive experience within the project's community.

At the heart of our open-source ethos, OneUUID welcomes contributions and collaboration from developers worldwide. Our community-driven approach ensures that OneUUID continues to evolve and adapt, becoming an essential tool for those seeking smooth UUID management and enhanced integration linking. Whether you're building a Java plugin or a complex software application, OneUUID empowers you to streamline UUID handling, optimize efficiency.

## Getting Started

### Downloading
By following these simple steps, you can download the OneUUID JAR from the GitHub Releases section and take advantage of its advanced UUID-related functionalities. To get started, head to the homepage of the OneUUID GitHub repository. As you're already on the homepage, you can find the "Releases" tab right at the top of the page. Click on this tab to access all available releases for the OneUUID library.

In the "Releases" section, you'll find a comprehensive list of different versions of OneUUID. Each release represents a stable version of the JAR, featuring improvements, bug fixes, and new features. Take your time to review the release notes and descriptions to identify the version that aligns with your requirements and setup. Selecting the appropriate release will ensure the best compatibility and optimal performance for your server network.

Once you have chosen the desired release version of OneUUID, look for the downloadable JAR file associated with that specific release. Usually, the JAR file follows a naming convention like "OneUUID-1.0.0.jar," where "1.0.0" represents the version number. Click on the link for the JAR file to initiate the download process.

After the download is complete, double-check that the JAR file is properly stored in a location accessible by your Java editor. Congratulations! You have successfully downloaded the OneUUID JAR! This powerful library is now at your disposal, ready to elevate your Minecraft server network with advanced UUID-related functionalities.

### Use OneUUID
```java
public class SimpleExample {
    public static void main(String[] args) {
        // Create a sample UUID string.
        String uuidString = "a190fd62-60bd-4b7c-a60b-5d41b62fe5e6";

        // Create a OneUUID object from the UUID string using OneUUID.fromString().
        OneUUID oneUUID = OneUUID.fromString(uuidString);

        // Display the original UUID string and the generated OneUUID object.
        System.out.println("Original UUID String: " + uuidString);
        System.out.println("Generated OneUUID instance: " + oneUUID);
    }
}
```

### Complex Usage
For example, let's say you had a class named `PlayerData` with whatever information you're trying to hold on to. (Using a OneUUID of course!) It could look something like this... (most importantly, it should have a uuid field! You can get away without, but it can help you later.)

```java
public class PlayerData {
    private OneUUID uuid;
    private int money;

    // Add other relevant fields and methods as needed

    public PlayerData(OneUUID uuid, int money) {
        this.uuid = uuid;
        this.money = money;
    }

    public void getMoney() {
        return money;
    }

    public void setMoney(int to) {
        money = to;
    }

    public void addMoney(int add) {
        setMoney(getMoney() + add);
    }
    
    // Add getters and setters for uuid and other fields.
}
```

With this guide, you can efficiently manage player data in your Minecraft plugin by utilizing a `HashMap` setup with OneUUID and `PlayerData`. The unique identifiers provided by OneUUID ensure data consistency and smooth functionality within your plugin, even when players change their in-game names and Java messing up between classes and their runtimes.

Within your Minecraft plugin (or other Java application), create a `HashMap` to store player data with OneUUID as keys and PlayerData objects as values. This association will enable efficient retrieval and management of player data using their unique identifiers.

```java
public class Economy extends CommandExecutor {
    // Create the HashMap with OneUUIDs as the key.
    private HashMap<OneUUID, PlayerData> players = new HashMap<>();
    
    // Make a method to create or fetch player data.
    public PlayerData getPlayer(OneUUID uuid) {
        if(!players.containsKey(uuid)) {
            PlayerData gen = new PlayerData(uuid, 100);
            players.put(uuid, gen);
            return gen;
        } else {
            return players.get(uuid);
        }
    }

    // Add a command listener... (Minecraft only!)
    @EventListener
    public void onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender typeof Player) return true;
        OneUUID uuid = OneUUID.fromString(((Player) sender).getUniqueId());
        PlayerData player = getPlayer(uuid);
        sender.sendMessage(ChatColor.YELLOW + "Balance: $" + player.getMoney());
        return false;
    }

    // You can add other methods to interact with player data in the HashMap...
}
```


## The SB4D Program
We are excited to introduce you to a unique opportunity to expand your Minecraft experience through the SB4D Program. Our mission is to empower developers like you within our player community, enabling you to create exceptional server networks with the same cutting-edge technology that powers Sandbattle. With SB4D, you have the freedom to unleash your creativity and craft server experiences that leave a lasting impact on players.

We offer a wide variety of extensions and preconfigured server plugins that provide essential controls... We believe in fostering creativity and innovation, which is why we offer a free tier that allows developers to explore, experiment, and showcase their talents to the larger Minecraft community. For those seeking to take their server networks to new heights, we also provide a paid tier. This tier unlocks access to a rich library of premium extensions, like new, exciting gameplay mechanics.

At Sandbattle, we understand the importance of nurturing a vibrant community of creators. The SB4D Program not only equips you with the necessary tools but also offers a supportive environment where ideas can flourish, and collaborations can thrive. So, we invite you to join our community of developers, where you can share your unique creations, learn from one another, and embark on an incredible journey of skill development and growth.

By being a part of the SB4D Program, you are not just creating server networks – you are shaping the future of Minecraft gaming. Your creativity and passion are what will drive the evolution of this dynamic world, and we are thrilled to be on this journey with you. Our service model is designed to cater to both aspiring developers and seasoned experts! So let's get started! Visit https://developers.sandbattle.com to learn more.

### Configure Extensions
With the SB4D Program, converting your existing `JavaPlugin` instance (your plugin's main class) into `JavaPluginExtended` is a straightforward process. By following these simple steps, you can unlock the full potential of SB4D in a JAR server plugin. You must import and download the Extensions library from your developer portal. This setup library is also [open source](https://github.com/sandbattle/extensions).

```java
// First import the essential class.
import com.sandbattle.extensions.JavaPluginExtended; 
```

In your existing plugin class (let's call it `MyPlugin`), change the class declaration to extend `JavaPluginExtended` instead of `JavaPlugin`. This is just an example setup, and you should feel free to modify anything to make your plugin work best! Some third-party modifications may not accept a `JavaPluginExtended` in their constructor, and asseting that `this` is still a `JavaPlugin`.

```java
// Now, change JavaPlugin to JavaPluginExtended.

public class MyPlugin extends JavaPluginExtended {
    public void onEnable() {}
}
```

Lastly, import your favorite extensions in your `onEnable()` function. This step will depend on what library you are using from us or other supported third-party providers. In this example, we are importing the TextSpace Translator plugin. For reference, this plugin uses plugin message channel for cache data transfer between nodes.

```java
// Add the translation extension to the instance.

public void onEnable() {
    TranslationExtension ext = new TranslationExtension(this);
    this.addExtension(ext);

    // more code ...
}
```

### This Library
We are pleased to present our library as a free and open-source solution! To simplify the integration process, we have opted for the JAR format, which offers a streamlined approach and ensures compatibility across various platforms. In addition, we have provided this informative description to assist you in finding any additional resources or documentation you might need while working with Java. Our primary aim is to make the utilization of this library as convenient and efficient as possible, empowering developers to harness its capabilities seamlessly in their projects. Feel free to explore the possibilities and advantages our library has to offer!

## Extra Resources
https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html

https://www.geeksforgeeks.org/compare-two-strings-in-java/

https://www.javatpoint.com/string-comparison-in-java

https://stackoverflow.com/questions/3804591/efficient-method-to-generate-uuid-string-in-java-uuid-randomuuid-tostring-w

https://www.simplilearn.com/tutorials/java-tutorial/string-comparison-in-java

https://stackoverflow.com/questions/29059530/is-there-any-way-to-generate-the-same-uuid-from-a-string

## Attributions
Inspired by the constant struggle of UUIDs and HashMaps across different Minecraft `Player` instances! Unfortunatly this small of a library doesn't have many contributors! If you think this should be updated please contact our development team.

## Contributing
Join the Sandbattle community and be part of our exciting game development journey! We invite developers, gamers, and enthusiasts alike to contribute to our thriving GitHub repository. As a leading games producer, Sandbattle values the power of collaboration and diverse perspectives. By contributing to our open-source projects, you can play a crucial role in shaping the future of our games, making them even more immersive and enjoyable for players worldwide.

Whether you're a seasoned coder or just starting, your ideas and efforts are valuable to us. Join our passionate community, share your expertise, and gain valuable experience in the dynamic world of game development. Together, let's create captivating gaming experiences that will delight and entertain audiences for years to come. Jump into the Sandbattle GitHub repository and let the games begin!

### **Happy coding!**
