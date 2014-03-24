--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: fernando
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO fernando;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: price; Type: TABLE; Schema: public; Owner: fernando; Tablespace: 
--

CREATE TABLE price (
    id bigint NOT NULL,
    version bigint NOT NULL,
    date timestamp without time zone NOT NULL,
    notes character varying(255) NOT NULL,
    price real NOT NULL,
    product_id bigint NOT NULL,
    store character varying(255) NOT NULL
);


ALTER TABLE public.price OWNER TO fernando;

--
-- Name: product; Type: TABLE; Schema: public; Owner: fernando; Tablespace: 
--

CREATE TABLE product (
    id bigint NOT NULL,
    version bigint NOT NULL,
    barcode character varying(255) NOT NULL,
    description character varying(255) NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.product OWNER TO fernando;

--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: fernando
--

SELECT pg_catalog.setval('hibernate_sequence', 42, true);


--
-- Data for Name: price; Type: TABLE DATA; Schema: public; Owner: fernando
--

COPY price (id, version, date, notes, price, product_id, store) FROM stdin;
30	0	2014-03-21 23:07:35.352	500 g. Campbell	3	1	Disco
31	0	2014-03-21 23:22:59.78	100 g. Quaker	3	10	Dinosaurio
32	0	2014-03-21 23:25:03.826	500 g. Campbell	4	5	Carrefour
33	0	2014-03-21 23:25:37.117	500 g. Campbell	3	5	Dinosaurio
34	0	2014-03-21 23:26:21.563	500 g. Campbell	5	5	Disco
35	0	2014-03-22 00:04:10.714	200 g. Quaker	2	4	Dinosaurio
36	0	2014-03-23 14:57:00.773	500 g. Quaker	5	5	Wall-Mart
37	0	2014-03-23 15:00:32.786	500 g. Quaker	4	1	Wall-Mart
38	0	2014-03-23 19:56:25.468	100 g. Quaker	2	10	Wall-Mart
39	0	2014-03-23 20:18:24.026	200 g. Quaker	3	10	Dinosaurio
40	0	2014-03-23 20:23:30.352	100 g. Quaker	3	12	Disco
41	0	2014-03-23 22:22:23.061	200 g. Quaker	3.11999989	3	Wall-Mart
42	0	2014-03-23 22:23:49.922	100 g. Quaker	1.59000003	1	Dinosaurio
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: fernando
--

COPY product (id, version, barcode, description, name) FROM stdin;
2	2	101	food	rice
11	11	110	food	soy beans
6	7	105	food	honey
7	8	106	food	peanuts
9	10	108	food	almonds
8	9	107	food	beef
4	6	103	food	donuts
5	13	104	food	pizza
10	14	109	food	walnuts
12	14	111	food	hamburger
3	6	102	food	grits
1	4	100	food	oats
\.


--
-- Name: price_pkey; Type: CONSTRAINT; Schema: public; Owner: fernando; Tablespace: 
--

ALTER TABLE ONLY price
    ADD CONSTRAINT price_pkey PRIMARY KEY (id);


--
-- Name: product_pkey; Type: CONSTRAINT; Schema: public; Owner: fernando; Tablespace: 
--

ALTER TABLE ONLY product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: fk65fb1492041d83b; Type: FK CONSTRAINT; Schema: public; Owner: fernando
--

ALTER TABLE ONLY price
    ADD CONSTRAINT fk65fb1492041d83b FOREIGN KEY (product_id) REFERENCES product(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

