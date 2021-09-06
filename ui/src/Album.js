import React, { useEffect, useState } from 'react';
import AppBar from '@material-ui/core/AppBar';
import Button from '@material-ui/core/Button';
import StoreTwoToneIcon from '@material-ui/icons/StoreTwoTone';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import CssBaseline from '@material-ui/core/CssBaseline';
import Grid from '@material-ui/core/Grid';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import Link from '@material-ui/core/Link';
import FormDialog from './FormDialog';

function Copyright() {
    return (
        <Typography variant="body2" color="textSecondary" align="center">
            {'Copyright © '}
            <Link color="inherit" href="https://material-ui.com/">tttruong701</Link>
            {' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}

const useStyles = makeStyles((theme) => ({
    appBar: {
        backgroundColor: "#045c5a"
    },
    icon: {
        marginRight: theme.spacing(2),
        fontSize: "300%"
    },
    heroContent: {
        backgroundColor: theme.palette.background.paper,
        padding: theme.spacing(8, 0, 6),
    },
    heroButtons: {
        marginTop: theme.spacing(4),
    },
    cardGrid: {
        paddingTop: theme.spacing(8),
        paddingBottom: theme.spacing(8),
    },
    card: {
        height: '100%',
        display: 'flex',
        flexDirection: 'column',
    },
    cardMedia: {
        paddingTop: '56.25%', // 16:9
    },
    cardContent: {
        flexGrow: 1,
    },
    footer: {
        backgroundColor: theme.palette.background.paper,
        padding: theme.spacing(6),
    },
}));

export default function Album() {
    const classes = useStyles();

    // Based on https://reactjs.org/docs/faq-ajax.html
    const [error, setError] = useState(null);
    // Flag is true if businesses have loaded.
    const [isLoaded, setIsLoaded] = useState(false);
    const [businesses, setBusinesses] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/v1/business")
            .then((response) => response.json())
            .then(
                (result) => {
                setIsLoaded(true);
                setBusinesses(result);
            },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            )
    }, [])

    if (error) {
        return <div>Error: {error}</div>;
    } else if (!isLoaded) {
        return <div>Loading...</div>;
    } else {
        return (
            <React.Fragment>
                <CssBaseline />

                {/* Navigation Bar */}
                <AppBar className={classes.appBar} position="relative">
                    <Toolbar>
                        <StoreTwoToneIcon className={classes.icon} />
                    </Toolbar>
                </AppBar>

                <main>

                    {/* Hero unit */}
                    <div className={classes.heroContent}>
                        <Container maxWidth="sm">
                            <Typography component="h1" variant="h2" align="center" color="textPrimary" gutterBottom>Save Our Faves SD</Typography>
                            <Typography variant="h8" align="center" color="textSecondary" paragraph>Let's help our local businesses survive the COVID-19 pandemic.</Typography>
                            <div className={classes.heroButtons}>
                                <Grid container spacing={2} justify="center">
                                    <Grid item>
                                        <FormDialog></FormDialog>
                                    </Grid>
                                </Grid>
                            </div>
                        </Container>
                    </div>

                    {/* Businesses */}
                    <Container className={classes.cardGrid} maxWidth="md">
                        <Grid container spacing={4}>
                            {businesses.map((business) => (
                                <Grid item key={business.id} xs={12} sm={6} md={4}>
                                    <Card className={classes.card}>
                                        <CardMedia className={classes.cardMedia} image="https://source.unsplash.com/random"title="Image title"/>
                                        <CardContent className={classes.cardContent}>
                                            <Typography gutterBottom variant="h5" component="h2">{business.name}</Typography>
                                        </CardContent>
                                        <CardActions>
                                            <Button size="small" color="primary" href={business.giftCardURL}>Purchase Gift Card</Button>
                                        </CardActions>
                                    </Card>
                                </Grid>
                            ))}
                        </Grid>
                    </Container>
                </main>

                {/* Footer */}
                <footer className={classes.footer}>
                    <Typography variant="h6" align="center" gutterBottom>Footer</Typography>
                    <Typography variant="subtitle1" align="center" color="textSecondary" component="p">Something here to give the footer a purpose!</Typography>
                    <Copyright />
                </footer>

            </React.Fragment>
        );

    }
}
