# Mumu Customization

一个功能强大的 Minecraft 服务器插件，用于自定义玩家进入和退出服务器时的消息。

**作者：** 困  
**版本：** 1.0.0  
**支持版本：** Minecraft 1.21.1 - 1.21.10

---

## ✨ 功能特点

- 🎨 **完全可自定义** - 自定义玩家进入/退出消息
- 👑 **OP专属消息** - 为管理员设置特殊的进入/退出消息
- 🎭 **玩家专属消息** - 为特定玩家设置独一无二的消息
- 📊 **优先级系统** - 单独玩家 > OP > 默认消息
- 🌈 **丰富的颜色** - 支持 MiniMessage 格式、渐变色、彩虹色
- 🔄 **热重载** - 无需重启服务器即可更新配置

---

## 📦 安装

1. 下载 `MumuCustomization-1.0.0.jar`
2. 将文件放入服务器的 `plugins` 文件夹
3. 重启服务器
4. 配置文件会自动生成在 `plugins/MumuCustomization/config.yml`

---

## ⚙️ 配置

### 基本配置

```yaml
messages:
  # 默认玩家消息
  join: "<green><bold>➤</bold> <yellow>%player%</yellow> <green>加入了服务器</green>"
  quit: "<red><bold>➤</bold> <yellow>%player%</yellow> <red>离开了服务器</red>"
  
  # OP管理员消息
  op:
    join: "<gold><bold>★</bold></gold> <gradient:yellow:gold>管理员 %player%</gradient> <gold>上线了!</gold>"
    quit: "<gold><bold>★</bold></gold> <gradient:yellow:gold>管理员 %player%</gradient> <gold>下线了!</gold>"
  
  # 单独玩家消息
  players:
    Notch:
      join: "<rainbow><bold>%player%</bold></rainbow> <light_purple>降临服务器!</light_purple>"
      quit: "<rainbow><bold>%player%</bold></rainbow> <light_purple>离开了服务器!</light_purple>"
```

### 消息优先级

插件按以下优先级选择消息：

1. **单独玩家消息** - `messages.players.<玩家名>`
2. **OP管理员消息** - `messages.op`
3. **默认消息** - `messages.join/quit`

---

## 🎨 颜色和样式

### 基础颜色

```yaml
<white> <yellow> <gold> <red> <dark_red>
<green> <dark_green> <aqua> <dark_aqua>
<blue> <dark_blue> <light_purple> <dark_purple>
<gray> <dark_gray> <black>
```

### 文本样式

```yaml
<bold>           # 粗体
<italic>         # 斜体
<underline>      # 下划线
<strikethrough>  # 删除线
<obfuscated>     # 混淆
```

### 高级效果

```yaml
# 渐变色
<gradient:red:blue>文本</gradient>

# 彩虹色
<rainbow>文本</rainbow>

# 十六进制颜色
<#ff0000>文本</#ff0000>

# 组合使用
<gradient:gold:yellow><bold>%player%</bold></gradient>
```

### 占位符

- `%player%` - 玩家名称

---

## 💻 命令

| 命令 | 描述 | 权限 |
|------|------|------|
| `/mumu reload` | 重载配置文件 | `mumucustomization.reload` |
| `/pjqm reload` | 重载配置文件（别名） | `mumucustomization.reload` |

---

## 🎯 配置示例

### 简洁风格

```yaml
messages:
  join: "<green>+ %player%"
  quit: "<red>- %player%"
  op:
    join: "<gold>+ [OP] %player%"
    quit: "<gold>- [OP] %player%"
```

### 渐变色风格

```yaml
messages:
  join: "<gradient:green:aqua>%player% 来了!</gradient>"
  quit: "<gradient:red:dark_red>%player% 走了!</gradient>"
  op:
    join: "<gradient:yellow:gold>管理员 %player% 上线!</gradient>"
    quit: "<gradient:yellow:gold>管理员 %player% 下线!</gradient>"
```

### 彩虹风格

```yaml
messages:
  join: "<rainbow>%player% 加入了服务器!</rainbow>"
  quit: "<rainbow>%player% 离开了服务器!</rainbow>"
```

### 完整配置示例

```yaml
messages:
  join: "<green>%player% 加入了服务器</green>"
  quit: "<red>%player% 离开了服务器</red>"
  
  op:
    join: "<gold><bold>★</bold> 管理员 %player% 上线了!</gold>"
    quit: "<gold><bold>★</bold> 管理员 %player% 下线了!</gold>"
  
  players:
    ServerOwner:
      join: "<light_purple><bold>⭐ 服主 %player% 降临! ⭐</bold></light_purple>"
      quit: "<light_purple><bold>⭐ 服主 %player% 离开! ⭐</bold></light_purple>"
    
    VIPPlayer:
      join: "<gradient:gold:yellow><bold>[VIP]</bold> %player% 进入服务器</gradient>"
      quit: "<gradient:gold:yellow><bold>[VIP]</bold> %player% 退出服务器</gradient>"
```

---

## 🔧 开发和构建

### 前置要求

- Java 21 或更高版本
- Maven 3.6 或更高版本

### 构建插件

```bash
mvn clean package
```

构建完成后，插件文件位于 `target/MumuCustomization-1.0.0.jar`

---

## 📋 技术信息

- **API 版本：** 1.21
- **依赖：** Paper API, Adventure API
- **兼容服务器：** Paper, Purpur, Spigot

---

## 📝 许可证

本项目为开源项目，可自由使用和修改。

---

## 💬 支持

如有问题或建议，欢迎提出 Issue。

---

**享受你的自定义消息！** ✨
