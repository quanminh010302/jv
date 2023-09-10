import { useEffect, useState } from 'react';

import Apis, { endpoints } from '../config/Apis';
import { Button, Container, Form, Nav, NavDropdown, Navbar, Spinner } from 'react-bootstrap';
import MySpinner from '../component/MySpinner';

const Header = () => {
    const [categories, setCategories] = useState(null);
    const loadCates = async () => {
        let res = await Apis.get(endpoints[`categories`])
        setCategories(res.data);

    }
    useEffect(() => {
        loadCates();
    }, []
    )

    if (categories === null) {
        return <MySpinner />;
    }


    return (
        <>


            <Navbar expand="lg" className="bg-body-tertiary">
                <Container fluid>
                    <Navbar.Brand href="#">Quản Lý Thu Chi</Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbarScroll" />
                    <Navbar.Collapse id="navbarScroll">
                        <Nav
                            className="me-auto my-2 my-lg-0"
                            style={{ maxHeight: '100px' }}
                            navbarScroll
                        >

                            <Nav.Link href="#action1">Home</Nav.Link>
                            <Nav.Link href="#action2"></Nav.Link>
                            <NavDropdown title="Phiếu" id="navbarScrollingDropdown">
                                {categories.map(c => <li key={c.id}>{c.name}</li>)}
                            </NavDropdown>
                            <Nav.Link href="#" disabled>
                                Danh Mục
                            </Nav.Link>
                        </Nav>
                        <Form className="d-flex">
                            <Form.Control
                                type="search"
                                placeholder="Search"
                                className="me-2"
                                aria-label="Search"
                            />
                            <Button variant="outline-success">Search</Button>
                        </Form>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </>
    )
}
export default Header;
