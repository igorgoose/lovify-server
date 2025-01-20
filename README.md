# lovify-server

## Локальный запуск

Должны быть установлены:
- Docker

Для локального запуска выполнить команду из папки проекта:

```bash
  docker compose -f compose-local-full.yaml up -d
```

Автоматически поднимутся контейнеры из `compose.yaml`, так что нужно проследить, что нужные порты свободны.
Само приложение будет доступно на порту `8080`.

## Особенности API превью персонажа

Доступные рабочие параметры:
- `skinColor`: все что может влезть в проперти css `fill`
- `hair.id`: hair-med-1, hair-med-11
- `eyes.id`: eyes-2
- `eyebrows.id`: eyebrow-thin
- `bodyType.id`: body-straight, body-buxom
- `faceType.id`: face-oval, face-soft
- `nose.id`: nose-12
- `mouth.id`: mouth-1, mouth-2
- `topClothing.id`: clothing-top-shirt129-body-buxom, clothing-top-shirt116-body-buxom, clothing-top-shirt0-body-straight,
clothing-top-shirt130-body-straight
- `rightLeg.id`,`leftLeg.id`: leg-2, leg-7 

Перечисленные поля обязательны к заполнению. Остальные поля не учитываются.