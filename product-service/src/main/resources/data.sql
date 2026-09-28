-- =========================
-- Categories
-- =========================
INSERT
IGNORE INTO category
    (name, description, code, active, created_at, updated_at)
VALUES
    ('Phones',
     'Smartphones and mobile phones',
     'PHONE',
     TRUE,
     CURRENT_TIMESTAMP,
     CURRENT_TIMESTAMP),

    ('Laptops',
     'Laptops and notebooks',
     'LAPTOP',
     TRUE,
     CURRENT_TIMESTAMP,
     CURRENT_TIMESTAMP),

    ('Audio',
     'Headphones, earbuds and audio devices',
     'AUDIO',
     TRUE,
     CURRENT_TIMESTAMP,
     CURRENT_TIMESTAMP),

    ('Accessories',
     'Computer and mobile accessories',
     'ACCESSORY',
     TRUE,
     CURRENT_TIMESTAMP,
     CURRENT_TIMESTAMP),

    ('Monitors',
     'Computer monitors and displays',
     'MONITOR',
     TRUE,
     CURRENT_TIMESTAMP,
     CURRENT_TIMESTAMP),

    ('Gaming Consoles',
     'Gaming consoles and related devices',
     'CONSOLE',
     TRUE,
     CURRENT_TIMESTAMP,
     CURRENT_TIMESTAMP);
-- =========================
-- Products
-- =========================

INSERT IGNORE INTO product
(
    name,
    description,
    sku,
    price,
    stock_quantity,
    active,
    category_id,
    created_at,
    updated_at
)

SELECT
    'iPhone 17',
    'Apple iPhone 17 256GB',
    'PHONE-IPHONE17-256',
    999.99,
    25,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'PHONE'

UNION ALL

SELECT
    'iPhone 17 Pro',
    'Apple iPhone 17 Pro 512GB',
    'PHONE-IPHONE17-PRO',
    1299.99,
    15,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'PHONE'

UNION ALL

SELECT
    'Samsung Galaxy S25',
    'Samsung Galaxy S25 256GB',
    'PHONE-GALAXY-S25',
    899.99,
    30,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'PHONE'

UNION ALL

SELECT
    'Google Pixel 10',
    'Google Pixel 10 256GB',
    'PHONE-PIXEL10-256',
    799.99,
    20,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'PHONE'

UNION ALL

SELECT
    'MacBook Pro 14',
    'Apple MacBook Pro 14 inch M4',
    'LAPTOP-MACBOOK-PRO-14',
    1999.99,
    10,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'LAPTOP'

UNION ALL

SELECT
    'MacBook Air 15',
    'Apple MacBook Air 15 inch M4',
    'LAPTOP-MACBOOK-AIR-15',
    1499.99,
    18,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'LAPTOP'

UNION ALL

SELECT
    'Dell XPS 15',
    'Dell XPS 15 Intel Core Ultra laptop',
    'LAPTOP-DELL-XPS15',
    1599.99,
    12,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'LAPTOP'

UNION ALL

SELECT
    'Lenovo ThinkPad X1 Carbon',
    'Lenovo ThinkPad X1 Carbon business laptop',
    'LAPTOP-THINKPAD-X1',
    1399.99,
    22,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'LAPTOP'

UNION ALL

SELECT
    'Sony WH-1000XM6',
    'Sony wireless noise cancelling headphones',
    'AUDIO-SONY-WH1000XM6',
    399.99,
    40,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'AUDIO'

UNION ALL

SELECT
    'Apple AirPods Pro',
    'Apple AirPods Pro wireless earbuds',
    'AUDIO-AIRPODS-PRO2',
    249.99,
    50,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'AUDIO'

UNION ALL

SELECT
    'Samsung Galaxy Buds',
    'Samsung wireless Bluetooth earbuds',
    'AUDIO-GALAXY-BUDS',
    149.99,
    35,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'AUDIO'

UNION ALL

SELECT
    'Logitech MX Master 3S',
    'Wireless ergonomic mouse',
    'MOUSE-MX-MASTER-3S',
    99.99,
    75,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'ACCESSORY'

UNION ALL

SELECT
    'Logitech MX Keys',
    'Wireless mechanical-style keyboard',
    'KEYBOARD-MX-KEYS',
    119.99,
    60,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'ACCESSORY'

UNION ALL

SELECT
    'Keychron K8 Pro',
    'Wireless mechanical keyboard',
    'KEYBOARD-KEYCHRON-K8',
    129.99,
    35,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'ACCESSORY'

UNION ALL

SELECT
    'Samsung 32 Inch Monitor',
    '32 inch 4K UHD monitor',
    'MONITOR-SAMSUNG-32',
    449.99,
    20,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'MONITOR'

UNION ALL

SELECT
    'LG UltraWide 34',
    '34 inch UltraWide QHD monitor',
    'MONITOR-LG-ULTRAWIDE34',
    599.99,
    14,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'MONITOR'

UNION ALL

SELECT
    'PlayStation 5',
    'Sony PlayStation 5 gaming console',
    'CONSOLE-PS5',
    499.99,
    12,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'CONSOLE'

UNION ALL

SELECT
    'Xbox Series X',
    'Microsoft Xbox Series X gaming console',
    'CONSOLE-XBOX-SERIES-X',
    499.99,
    8,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'CONSOLE'

UNION ALL

SELECT
    'Nintendo Switch 2',
    'Nintendo Switch 2 gaming console',
    'CONSOLE-SWITCH-2',
    449.99,
    16,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'CONSOLE'

UNION ALL

SELECT
    'Anker Power Bank',
    'Anker 20000mAh portable power bank',
    'ACCESSORY-ANKER-20K',
    59.99,
    100,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'ACCESSORY'

UNION ALL

SELECT
    'Old iPhone Case',
    'Discontinued iPhone protective case',
    'ACCESSORY-OLD-CASE',
    19.99,
    0,
    FALSE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'ACCESSORY'

UNION ALL

SELECT
    'USB-C Cable',
    'USB-C fast charging cable',
    'ACCESSORY-USB-C-CABLE',
    14.99,
    0,
    TRUE,
    c.id,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM category c
WHERE c.code = 'ACCESSORY';