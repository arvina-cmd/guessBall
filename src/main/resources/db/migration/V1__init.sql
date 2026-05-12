-- 队伍表
CREATE TABLE IF NOT EXISTS teams (
    code        VARCHAR(10)  PRIMARY KEY,
    name_zh     VARCHAR(50),
    name_en     VARCHAR(100) NOT NULL,
    crest_url   VARCHAR(255),
    group_name  VARCHAR(10),
    external_id INT,
    competition VARCHAR(10)
);

-- 比赛表
CREATE TABLE IF NOT EXISTS matches (
    id                BIGSERIAL    PRIMARY KEY,
    external_id       INT          NOT NULL,
    competition       VARCHAR(10)  NOT NULL,
    home_team_code    VARCHAR(10),
    away_team_code    VARCHAR(10),
    home_team_name    VARCHAR(100),
    away_team_name    VARCHAR(100),
    home_team_crest   VARCHAR(255),
    away_team_crest   VARCHAR(255),
    match_time        TIMESTAMPTZ  NOT NULL,
    predict_deadline  TIMESTAMPTZ  NOT NULL,
    stage             VARCHAR(30)  NOT NULL,
    group_name        VARCHAR(10),
    matchday          INT,
    home_score        INT,
    away_score        INT,
    home_score_et     INT,
    away_score_et     INT,
    home_score_pk     INT,
    away_score_pk     INT,
    winner            VARCHAR(20),
    status            VARCHAR(20)  DEFAULT 'SCHEDULED',
    last_synced_at    TIMESTAMPTZ,
    created_at        TIMESTAMPTZ  DEFAULT NOW(),
    updated_at        TIMESTAMPTZ  DEFAULT NOW(),
    UNIQUE (external_id, competition)
);

-- 用户表
CREATE TABLE IF NOT EXISTS users (
    id            BIGSERIAL    PRIMARY KEY,
    username      VARCHAR(50)  UNIQUE NOT NULL,
    email         VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    total_points  INT          DEFAULT 0,
    exact_hits    INT          DEFAULT 0,
    result_hits   INT          DEFAULT 0,
    created_at    TIMESTAMPTZ  DEFAULT NOW()
);

-- 竞猜表
CREATE TABLE IF NOT EXISTS predictions (
    id             BIGSERIAL   PRIMARY KEY,
    user_id        BIGINT      NOT NULL REFERENCES users(id),
    match_id       BIGINT      NOT NULL REFERENCES matches(id),
    predicted_home INT         NOT NULL,
    predicted_away INT         NOT NULL,
    points_earned  INT         DEFAULT 0,
    is_settled     BOOLEAN     DEFAULT FALSE,
    created_at     TIMESTAMPTZ DEFAULT NOW(),
    UNIQUE (user_id, match_id)
);

-- 小组积分榜
CREATE TABLE IF NOT EXISTS group_standings (
    id            BIGSERIAL   PRIMARY KEY,
    competition   VARCHAR(10) NOT NULL,
    team_code     VARCHAR(10) NOT NULL,
    team_name     VARCHAR(100),
    team_crest    VARCHAR(255),
    group_name    VARCHAR(10) NOT NULL,
    position      INT,
    played        INT         DEFAULT 0,
    won           INT         DEFAULT 0,
    drawn         INT         DEFAULT 0,
    lost          INT         DEFAULT 0,
    goals_for     INT         DEFAULT 0,
    goals_against INT         DEFAULT 0,
    points        INT         DEFAULT 0,
    updated_at    TIMESTAMPTZ DEFAULT NOW(),
    UNIQUE (competition, team_code, group_name)
);

CREATE INDEX IF NOT EXISTS idx_matches_status      ON matches(status);
CREATE INDEX IF NOT EXISTS idx_matches_time        ON matches(match_time);
CREATE INDEX IF NOT EXISTS idx_matches_competition ON matches(competition);
CREATE INDEX IF NOT EXISTS idx_predictions_user    ON predictions(user_id);
CREATE INDEX IF NOT EXISTS idx_predictions_match   ON predictions(match_id);
